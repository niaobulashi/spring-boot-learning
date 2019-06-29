package com.niaobulashi.controller;

import com.niaobulashi.entity.SysUserEntity;
import com.niaobulashi.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SysUserController {

    private Logger logger = LoggerFactory.getLogger(SysUserController.class);

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询所有用户信息
     * @return
     */
    @RequestMapping("/getAll")
    private List<SysUserEntity> getUser() {
        List<SysUserEntity> userList = sysUserService.queryUserAll();
        return userList;
    }

    /**
     * 根据userId查询用户信息
     * @return
     */
    @RequestMapping("/getUser")
    private List<SysUserEntity> getUser(@RequestParam(value = "userId", required = false) Long userId) {
        List<SysUserEntity> userList = sysUserService.queryUserInfo(userId);
        return userList;
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    private int updateUser(@RequestBody SysUserEntity user) {
        return sysUserService.updateUserInfo(user);
    }

}
