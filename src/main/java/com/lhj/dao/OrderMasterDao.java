package com.lhj.dao;

import com.lhj.entity.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 订单主表dao
 * @author lhj on 2022/4/27
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
    /**
     * 根据openid查订单列表并分页
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
