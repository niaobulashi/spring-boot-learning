package com.niaobulashi.controller;

import com.niaobulashi.model.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-19-shiro
 * @description:
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-10 00:30
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final ResultMap resultMap;

    @Autowired
    public AdminController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMap getMessage() {
        return resultMap.success().message("您拥有管理员权限，可以获得该接口的信息！");
    }
}
