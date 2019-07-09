package com.niaobulashi.mapper;

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
     * @param username 用户名
     * @return user/admin
     */
    String getRole(String username);
}

