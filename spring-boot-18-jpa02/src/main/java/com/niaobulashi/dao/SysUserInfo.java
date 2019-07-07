package com.niaobulashi.dao;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-07 15:35
 */
public interface SysUserInfo {

    String getUserId();

    String getUserName();

    String getEmail();

    String getPassWord();

    int getRoleId();
}
