package com.lhj.dao;

import com.lhj.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * 订单详情表dao
 *
 * @author lhj on 2022/4/27
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail,String> {
    /**
     * 根据订单id查订单详情
     * @param orderId
     * @return
     */
    List<OrderDetail> findByOrderId(String orderId);
}
