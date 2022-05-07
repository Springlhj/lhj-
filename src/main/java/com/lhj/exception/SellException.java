package com.lhj.exception;

import com.lhj.enums.ResultEnum;

/**
 * 异常处理
 *
 * @author lhj on 2022/4/28
 */
public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        //把resultEnum.getMessage()传到父类(RuntimeException)的构造方法中
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
