package com.lhj.service;

import com.lhj.dto.OrderDTO;

/**
 * 买家service
 *
 * @author lhj on 2022/6/20
 */
public interface BuyerService {
    /**
     * 查询一个订单
     */
    OrderDTO findOrderOne(String openid,String orderId);
    /**
     * 取消订单
     */
    OrderDTO cancelOrder(String openid,String orderId);
}
