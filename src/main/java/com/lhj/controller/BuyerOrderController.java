package com.lhj.controller;

import com.lhj.converter.OrderForm2OrderDTOConverter;
import com.lhj.dto.OrderDTO;
import com.lhj.enums.ResultEnum;
import com.lhj.exception.SellException;
import com.lhj.form.OrderForm;
import com.lhj.service.BuyerService;
import com.lhj.service.OrderService;
import com.lhj.utils.ResultVoUtil;
import com.lhj.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 买家订单controller
 *
 * @author lhj on 2022/6/13
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

    /**
     * 创建订单
     */
    @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderForm2OrderDTOConverter.convert(orderForm);
        //判断转换后购物车是否空了
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【创建订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String,String> map = new HashMap<>(16);
        map.put("orderId",createResult.getOrderId());
        return ResultVoUtil.success(map);
    }

    /**
     * 订单列表
     */
    @GetMapping("/list")
    public ResultVo<List<OrderDTO>> list(@RequestParam("openid")String openid,
                                         //page如果不传默认为0
                                         @RequestParam(value = "page",defaultValue = "0")Integer page,
                                         @RequestParam(value = "size",defaultValue = "10")Integer size){
        if(StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = new PageRequest(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid, request);
        return ResultVoUtil.success(orderDTOPage.getContent());
    }

    /**
     * 订单详情
     */
    @GetMapping("/detail")
    public ResultVo<OrderDTO> detail(@RequestParam("openid")String openid,
                                     @RequestParam("orderId")String orderId){
        //todo 不安全的做法(越权访问,任何人随便传个orderId都可以调此接口,这是不安全的)
        OrderDTO orderOne = buyerService.findOrderOne(openid, orderId);
        return ResultVoUtil.success(orderOne);
    }

    /**
     * 取消订单
     */
    @PostMapping("/cancel")
    public ResultVo cancel(@RequestParam("openid")String openid,
                           @RequestParam("orderId")String orderId){
        buyerService.cancelOrder(openid,orderId);
        return ResultVoUtil.success();
    }
}
