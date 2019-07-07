package com.niaobulashi.web;

import com.niaobulashi.dao.SysUserInfo;
import com.niaobulashi.dao.SysUserRoleDao;
import com.niaobulashi.dao.SysUserDao;
import com.niaobulashi.entity.SysUser;
import com.niaobulashi.entity.SysUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: https://niaobulashi.com
 * @create: 2019-07-07 02:08
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 用户表sys_user，用户角色对照表sys_user_role。数据初始化
     */
    //发送get请求进行数据添加：127.0.0.1:8081/user/init
    @RequestMapping(value = "/init", method = RequestMethod.GET)
    public String initData() {
        for (int i = 1; i < 6; i++) {
            // 根据时间戳生成userId
            String userId = String.valueOf(System.currentTimeMillis());
            // new出用户表和用户角色表的对象
            SysUser sysUser = new SysUser();
            SysUserRole sysUserRole = new SysUserRole();
            // 新增用户表
            sysUser.setUserId(userId);
            sysUser.setUserName("username_num" + i);
            sysUser.setPassWord("password_num" + i);
            sysUser.setEmail("email_num" + i + "@qq.com");
            sysUser.setSalt(i + "");
            sysUser.setRegTime(new Date());
            sysUserDao.save(sysUser);

            // 暂时规定小于3的，角色为1，新建用户角色表
            if (i < 3) {
                sysUserRole.setId(i);
                sysUserRole.setUserId(userId);
                sysUserRole.setRoleId(1);
                sysUserRoleDao.save(sysUserRole);
            } else {
                // 大于3的，角色为2
                sysUserRole.setId(i);
                sysUserRole.setUserId(userId);
                sysUserRole.setRoleId(2);
                sysUserRoleDao.save(sysUserRole);
            }
        }
        return "init data success";
    }

    /**
     * 删除
     */
    // 发送get请求：127.0.0.1:8081/user/delete/1562486017644
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("userId") String userId) {
        sysUserDao.deleteByUserId(userId);
        return "delete success";
    }

    /**
     * 查询全部
     * @return
     */
    // 发送get请求：127.0.0.1:8081/user/list
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<SysUser> getUsers() {
        return sysUserDao.findAll();
    }

    /**
     * 根据id查询
     */
    // 发送get请求：127.0.0.1:8081/user/info/1562486017644
    @RequestMapping(value = "/info/{userId}", method = RequestMethod.GET)
    public Optional<SysUser> getUserById(@PathVariable("userId") String userId) {
        return sysUserDao.findByUserId(userId);
    }

    /**
     * 更新
     */
    // 发送post请求：127.0.0.1:8081/user/update
    // 发送报文体如下
    /*
     {
        "userId":"1562486017551",
        "passWord": "231231231212312",
        "userName":"Tom",
        "email": "1111111@qq.com"
     }
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateAccount(@RequestBody HashMap<String, String> map) {
        // 根据Id更新用户信息
        sysUserDao.updateOne(
                map.get("email"),
                map.get("userName"),
                map.get("passWord"),
                map.get("userId"));
        return "update success";
    }

    /**
     * 关联查询用户的角色信息
     */
    // 发送post请求：127.0.0.1:8081/user/getUserRole
    // 发送报文体如下
    /*
      {
         "userId":"1562486017629"
      }
     */
    @RequestMapping(value = "/getUserRole", method = RequestMethod.POST)
    public List<SysUserInfo> getUserRole(@RequestBody HashMap<String, String> map) {
        return sysUserDao.findUserRole(map.get("userId"));
    }

    /**
     * 根据非主键username模糊查询
     */
    // 发送post请求：127.0.0.1:8081/user/getUserByUserName
    // 发送报文体如下
    /*
    {
        "userName":"username"
    }
     */
    @RequestMapping(value = "/getUserByUserName", method = RequestMethod.POST)
    public List<SysUser> getUserByUserName(@RequestBody HashMap<String, String> map) {
        return sysUserDao.findUserName(map.get("userName"));
    }
}
