package com.niaobulashi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-learning
 * @description: 用户表
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-09 22:48
 */
@Data
public class SysUser implements Serializable {

    /* 用户Id */
    private Long userId;

    /* 登录名 */
    private String loginName;

    /* 用户名称 */
    private String userName;

    /* 密码 */
    private String password;

    /* 盐 */
    private String salt;


    /**
     * 密码盐.
     *
     * @return
     */
    public String getCredentialsSalt() {
        return this.loginName + this.salt;
    }
}
