package com.niaobulashi.exception;

/**
 * @program: spring-boot-learning
 * @description: 自定义异常
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-07 22:29
 */
public class MyException extends Exception{
    public MyException(String message) {
        super(message);
    }
}
