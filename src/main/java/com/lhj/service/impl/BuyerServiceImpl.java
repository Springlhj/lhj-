package com.lhj.service.impl;

import com.lhj.dto.OrderDTO;
import com.lhj.enums.ResultEnum;
import com.lhj.exception.SellException;
import com.lhj.service.BuyerService;
import com.lhj.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 买家serviceImpl
 *
 * @author lhj on 2022/6/20
 */
@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService {
    @Autowired
    private OrderService orderService;

    @Override
    public OrderDTO findOrderOne(String openid, String orderId) {
        return checkOrderOwner(openid, orderId);
    }

    @Override
    public OrderDTO cancelOrder(String openid, String orderId) {
        OrderDTO orderDTO = checkOrderOwner(openid, orderId);
        //取消一个订单,当被取消的订单为null,那肯定就是错误的
        if(orderDTO == null){
            log.error("[取消订单]查不到该订单,orderId={}",orderId);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String openid, String orderId) {
        OrderDTO orderDTO = orderService.findOne(orderId);
        if(orderDTO == null){
            return null;
        }
        //判断是否是自己的订单
        if(orderDTO.getBuyerOpenid().equalsIgnoreCase(openid)){
            log.error("【查询订单】订单的openid不一致,openid={},orderDTO={}",openid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }

}
