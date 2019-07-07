package com.niaobulashi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: https://niaobulashi.com
 * @create: 2019-07-05 00:02
 */
@RestController
public class HelloController {

    @GetMapping("/filter")
    public String testFilter(){
        return "filter is ok";
    }
}
