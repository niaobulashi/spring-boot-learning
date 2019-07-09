package com.niaobulashi.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @program: spring-boot-learning
 * @description: 接口返回对象
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-09 12:30
 */
@Component
public class ResultMap extends HashMap<String, Object> {

    public ResultMap() {
    }

    public ResultMap success() {
        this.put("result", "success");
        return this;
    }

    public ResultMap fail() {
        this.put("result", "fail");
        return this;
    }

    public ResultMap message(Object message) {
        this.put("message", message);
        return this;
    }
}

