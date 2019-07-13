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
 * @create: 2019-07-10 00:32
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final ResultMap resultMap;

    @Autowired
    public UserController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    @RequestMapping(value = "/getMessage", method = RequestMethod.GET)
    public ResultMap getMessage() {
        return resultMap.success().message("您拥有用户权限，可以获得该接口的信息！");
    }
}
