package com.niaobulashi.controller;

import com.niaobulashi.entity.SysUserEntity;
import com.niaobulashi.mapper.master.SysUserMasterDao;
import com.niaobulashi.mapper.slave.SysUserSlaveDao;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: spring-boot-learning
 * @description: 系统用户Controller
 * @author: https://niaobulashi.com
 * @create: 2019-07-01 18:43
 */
@RestController
public class SysUserController {

    @Resource
    private SysUserMasterDao sysUserMasterDao;

    @Resource
    private SysUserSlaveDao sysUserSlaveDao;

    /**
     * 查询所有用户信息Master
     * @return
     */
    @RequestMapping("/getUserMasterAll")
    private List<SysUserEntity> getUserMaster() {
        System.out.println("查询主库");
        List<SysUserEntity> userList = sysUserMasterDao.queryUserAll();
        return userList;
    }

    /**
     * 查询所有用户信息Slave
     * @return
     */
    @RequestMapping("/getUserSlaveAll")
    private List<SysUserEntity> getUserSlave() {
        System.out.println("查询从库");
        List<SysUserEntity> userList = sysUserSlaveDao.queryUserAll();
        return userList;
    }

    /**
     * 根据userId查询用户信息Master
     * @return
     */
    @RequestMapping("/getUserMasterById")
    private List<SysUserEntity> getUserMasterById(@RequestParam(value = "userId", required = false) Long userId) {
        List<SysUserEntity> userList = sysUserMasterDao.queryUserInfo(userId);
        return userList;
    }

    /**
     * 根据userId查询用户信息Slave
     * @return
     */
    @RequestMapping("/getUserSlaveById")
    private List<SysUserEntity> getUserSlaveById(@RequestParam(value = "userId", required = false) Long userId) {
        List<SysUserEntity> userList = sysUserSlaveDao.queryUserInfo(userId);
        return userList;
    }

}

