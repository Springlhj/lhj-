package com.lhj.entity;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * @program: sell
 * @description: 类目实体
 * @author: lhj
 * @create: 2019-04-09 17:23
 * 数据库表:product_category
 **/
@Entity
//数据库修改时间字段设置为ON UPDATE CURRENT_TIMESTAMP字段时
//加此注解可以对时间字段动态修改  如果不加对数据进行编辑时updateTime字段不会更新
@DynamicUpdate
//自动生成getSet方法
@Data
public class ProductCategory {
    /**
     * 类目id
     */
    @Id
    @GeneratedValue
    private Integer categoryId;
    /**
     * 类目名字
     */
    private String categoryName;
    /**
     * 类目编号
     */
    private Integer categoryType;

//    private Date createTime;
//
//    private Date updateTime;

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }

    public ProductCategory() {
    }
}
