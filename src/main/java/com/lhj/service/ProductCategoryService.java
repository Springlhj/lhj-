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
    /**
     * 查一个
     * @param categoryId
     * @return
     */
    ProductCategory findOne(Integer categoryId);

    /**
     * 查所有
     * @return
     */
    List<ProductCategory> findAll();

    /**
     * 买家端(通过type查)
     * @param categoryTypes
     * @return
     */
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypes);

    /**
     * 新增和更新都是save方法
     * @param productCategory
     * @return
     */
    ProductCategory save(ProductCategory productCategory);
}
