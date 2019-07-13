package com.niaobulashi.controller;

import com.niaobulashi.mapper.UserMapper;
import com.niaobulashi.model.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: spring-boot-19-shiro
 * @description: 登录Controller
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-09 23:47
 */
@RestController
public class LoginController {

    @Autowired
    private ResultMap resultMap;

    @Autowired
    private UserMapper userMapper;


    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public ResultMap notLogin() {
        return resultMap.success().message("您尚未登陆！");
    }

    @RequestMapping(value = "/notRole", method = RequestMethod.GET)
    public ResultMap notRole() {
        return resultMap.success().message("您没有权限！");
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResultMap logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return resultMap.success().message("成功注销！");
    }

    /**
     * 登陆
     *
     * @param loginName 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMap login(String loginName, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        String role = userMapper.getRole(loginName);
        if ("user".equals(role)) {
            return resultMap.success().message("欢迎登陆");
        }
        if ("admin".equals(role)) {
            return resultMap.success().message("欢迎来到管理员页面");
        }
        return resultMap.fail().message("权限错误！");
    }

}
