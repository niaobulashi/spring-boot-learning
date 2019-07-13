package com.niaobulashi.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.niaobulashi.model.SysUser;
import com.niaobulashi.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-boot-12-mybatis-redis
 * @description: 数字字典
 * @author: https://niaobulashi.com
 * @create: 2019-06-30 13:47
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 查询用户信息列表1
     * @return
     */
    @RequestMapping(value = "/getAll1", method = RequestMethod.GET)
    private List<SysUser> getUserList() {
        List<SysUser> userList = sysUserService.queryUserList1();
        return userList;
    }
    /**
     * 查询用户信息列表2
     * @return
     */
    @RequestMapping(value = "/getAll2", method = RequestMethod.GET)
    private List<SysUser> getUserList2() {
        List<SysUser> userList = sysUserService.queryUserList2();
        return userList;
    }

    /**
     * 根据用户名模糊查询用户信息
     */
    @RequestMapping(value = "/getUserByName", method = RequestMethod.POST)
    private List<SysUser> getUserByName(@RequestBody SysUser sysUser) {
        List<SysUser> userList = sysUserService.queryUserListByName(sysUser.getUserNameStr());
        return userList;
    }

    /**
     * 根据用户名模糊查询用户信息
     */
    @RequestMapping(value = "/queryUserByNameAndEmail", method = RequestMethod.POST)
    private List<SysUser> queryUserByNameAndEmail(@RequestBody SysUser sysUser) {
        List<SysUser> userList = sysUserService.queryUserByNameAndEmail(sysUser);
        return userList;
    }

    /**
     * 根据用户名模糊查询用户信息，各种条件
     */
    @RequestMapping(value = "/queryUserByUser", method = RequestMethod.POST)
    private List<SysUser> queryUserByUser(@RequestBody SysUser sysUser) {
        List<SysUser> userList = sysUserService.queryUserByUser(sysUser);
        return userList;
    }

    /**
     * 查看用户部门和角色信息
     */
    @RequestMapping(value = "/queryUserRoleDept", method = RequestMethod.POST)
    private List<SysUser> queryUserRoleDept(@RequestBody SysUser sysUser) {
        List<SysUser> userList = sysUserService.queryUserRoleDept(sysUser);
        return userList;
    }

    /**
     * 分页查询
     */
    @RequestMapping(value = "/queryUserByPage", method = RequestMethod.GET)
    private PageInfo queryUserByPage(Integer currentPage, Integer pageSize) {
        PageHelper.startPage(currentPage, pageSize);
        List<SysUser> userList = sysUserService.queryUserRoleDept(new SysUser());
        PageInfo info=new PageInfo(userList);
        return info;
    }
}
