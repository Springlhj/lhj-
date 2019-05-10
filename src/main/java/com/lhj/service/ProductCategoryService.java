package com.lhj.service;

import com.lhj.entity.ProductCategory;

import java.util.List;

/**
 * @program: sell
 * @description: 商品类目service
 * @author: lhj
 * @create: 2019-04-30 15:26
 **/
public interface ProductCategoryService {
    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> findAll();

    /**
     * 买家端(通过type查)
     * @param categoryTypes
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

    ProductCategory save(ProductCategory productCategory);
}
