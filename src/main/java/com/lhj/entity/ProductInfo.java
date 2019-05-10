package com.lhj.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @program: sell
 * @description: 商品实体
 * @author: lhj
 * @create: 2019-04-30 15:49
 **/
@Entity
@Data
public class ProductInfo {
    @Id
    private String productId;
    /**
     * 商品名字
     */
    private String productName;
    /**
     * 商品单价
     */
    private BigDecimal productPrice;
    /**
     * 库存
     */
    private Integer productStock;
    /**
     * 描述
     */
    private String productDescription;
    /**
     * 小图片(链接地址)
     */
    private String productIcon;
    /**
     * 类目编号
     */
    private Integer categoryType;
    /**
     * 商品状态,0正常  1下架
     */
    private Integer productStatus;
    /**
     * 创建时间
     */
//    private Date createTime;
    /**
     * 修改时间
     */
//    private Date updateTime;
}
