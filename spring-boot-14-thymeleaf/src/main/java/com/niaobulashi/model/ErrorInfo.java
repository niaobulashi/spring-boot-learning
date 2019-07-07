package com.niaobulashi.model;

import lombok.Data;

/**
 * @program: spring-boot-learning
 * @description: 错误信息
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-07 22:28
 */
@Data
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;
}
