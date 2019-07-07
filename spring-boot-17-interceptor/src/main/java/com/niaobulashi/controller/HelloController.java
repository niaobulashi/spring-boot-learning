package com.niaobulashi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: https://niaobulashi.com
 * @create: 2019-07-06 16:38
 */
@RestController
public class HelloController {

    @RequestMapping("/interceptor")
    public String home(){
        return "interceptor is ok";
    }
}
