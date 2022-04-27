package com.lhj.service.impl;

import com.lhj.dto.OrderDTO;
import com.lhj.service.OrderService;
import com.lhj.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * 订单业务实现
 *
 * @author lhj on 2022/4/27
 */
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductInfoService productService;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        //1.查询商品(数量,价格)

        //2.计算总价

        //3.写入订单数据库(orderMaster和orderDetail)

        //4.扣库存

        return null;
    }

    @Override
    public OrderDTO findOne(String orderId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenid, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
