package com.lhj.enums;

import lombok.Getter;

/**
 * 商品状态
 */
@Getter
public enum ProductStatusEnum {
    //0表示上架  1表示下架
    UP(0,"在架"),
    DOWN(1,"下架")
    ;
    private Integer code;

    private String message;
    /**
     * 枚举构造方法
     * @param code
     */
    ProductStatusEnum(Integer code,String message) {
        this.code = code;
        this.message = message;
    }
}
