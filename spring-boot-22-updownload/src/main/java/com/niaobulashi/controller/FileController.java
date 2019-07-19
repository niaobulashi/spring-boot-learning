package com.niaobulashi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @program: spring-boot-learning
 * @description: 文件
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-19 15:28
 */
@Controller
public class FileController {
    @GetMapping("/")
    public String updatePage() {
        return "file";
    }
}

