package com.lhj.dao;

import com.lhj.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//JpaRepository<实体类,主键属性>
public interface ProductCategoryDao extends JpaRepository<ProductCategory,Integer> {
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
