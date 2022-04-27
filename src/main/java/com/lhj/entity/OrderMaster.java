package com.lhj.entity;

import com.lhj.enums.OrderStatusEnum;
import com.lhj.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 * @author lhj on 2022/4/27
 */
@Entity
@Data
/**
 * DynamicUpdate注解作用:自动更新updateTime字段
 */
@DynamicUpdate
public class OrderMaster {
    /**
     * 订单id
     */
    @Id
    private String orderId;
    /**
     * 买家名字
     */
    private String buyerName;
    /**
     * 买家手机号
     */
    private String buyerPhone;
    /**
     * 买家地址
     */
    private String buyerAddress;
    /**
     * 买家微信Openid
     */
    private String buyerOpenid;
    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;
    /**
     * 订单状态,默认为0新订单
     */
    private Integer orderStatus= OrderStatusEnum.NEW.getCode();
    /**
     * 支付状态,默认为0未支付
     */
    private Integer payStatus= PayStatusEnum.WAIT.getCode();
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
}
