package com.lhj.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 接口请求返回的最外层对象
 *
 * @author lhj on 2022/4/26
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVo<T> {
    /**
     * 错误码
     */
    private Integer code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回的具体内容
     */
    private T data;

}
