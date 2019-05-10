package com.lhj.service.impl;

import com.lhj.dao.ProductInfoDao;
import com.lhj.entity.ProductInfo;
import com.lhj.enums.ProductStatusEnum;
import com.lhj.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: sell
 * @description: 商品service
 * @author: lhj
 * @create: 2019-04-30 16:47
 **/
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public ProductInfo findOne(String ProductInfoId) {
        return productInfoDao.findOne(ProductInfoId);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoDao.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoDao.save(productInfo);
    }
}
