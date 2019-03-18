package com.niaobulashi.controller;

import com.niaobulashi.model.UserVo;
import com.niaobulashi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserInfoController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/getUser")
    private UserVo getUser() {
        UserVo userVo = new UserVo();
        userVo.setUserName("小明");
        userVo.setEmail("12");
        return userVo;
    }

    @RequestMapping("/getUserAA")
    public UserVo getUserAA() {
        UserVo user=userRepository.findByUserName("aa");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<UserVo> getUsers() {
        List<UserVo> users=userRepository.findAll();
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return users;
    }
}
