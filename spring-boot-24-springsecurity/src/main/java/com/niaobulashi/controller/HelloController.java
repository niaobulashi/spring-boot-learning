package com.niaobulashi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: spring-boot-learning
 * @description: 欢迎页面
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-24 19:10
 */
@Controller
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello SpringSecurity";
    }
}

