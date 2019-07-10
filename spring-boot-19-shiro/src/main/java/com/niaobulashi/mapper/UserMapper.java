package com.niaobulashi.mapper;

import com.niaobulashi.entity.SysUser;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-07-09 12:29
 */
public interface UserMapper {
    /**
     * 获得密码
     * @param username 用户名
     */
    String getPassword(String username);

    /**
     * 获得角色权限
     * @param loginName 用户名
     * @return user/admin
     */
    String getRole(String loginName);

    /**
     * 根据key，查询value
     */
    SysUser queryUserByLoginName(String loginName);
}

