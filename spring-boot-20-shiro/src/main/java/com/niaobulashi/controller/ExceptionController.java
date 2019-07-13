package com.niaobulashi.controller;

import com.niaobulashi.model.ResultMap;
import org.apache.shiro.authc.AccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: spring-boot-19-shiro
 * @description:
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-10 00:31
 */
@RestControllerAdvice
public class ExceptionController {
    private final ResultMap resultMap;

    @Autowired
    public ExceptionController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    /**
     * 捕捉 CustomRealm 抛出的异常
     */
    @ExceptionHandler(AccountException.class)
    public ResultMap handleShiroException(Exception ex) {
        return resultMap.fail().message(ex.getMessage());
    }
}
