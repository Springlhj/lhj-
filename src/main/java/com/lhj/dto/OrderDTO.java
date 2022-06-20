package com.lhj.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lhj.entity.OrderDetail;
import com.lhj.enums.OrderStatusEnum;
import com.lhj.enums.PayStatusEnum;
import com.lhj.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单数据传输对象
 *
 * @author lhj on 2022/4/27
 */
@Data
//筛出当前对象中的空值
//@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
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
    private Integer orderStatus;
    /**
     * 支付状态,默认为0未支付
     */
    private Integer payStatus;
    /**
     * 创建时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;
    /**
     * 修改时间
     */
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;
    /**
     * 订单详情list
     */
    private List<OrderDetail> orderDetailList;
}
