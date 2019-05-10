package com.lhj.dao;

import com.lhj.entity.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository<实体类,主键属性>
public interface ProductInfoDao extends JpaRepository<ProductInfo,String> {
    /**
     * 通过商品的状态 查询上架的商品
     * @return
     */
    List<ProductInfo> findByProductStatus(Integer productStatus);
}
