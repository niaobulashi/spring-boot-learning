package com.niaobulashi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: spring-boot-learning
 * @description: 用户信息表
 * @author: https://niaobulashi.com
 * @create: 2019-07-01 17:20
 */
@Data
public class SysUserEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //用户ID
    private Long userId;

    //用户名
    private String username;

    //密码
    private String password;

    //盐
    private String salt;

    //邮箱
    private String email;

    //手机号
    private String mobile;

    //状态  0：禁用   1：正常
    private Integer status;

    //部门ID
    private Long deptId;

    //创建时间
    private Date createTime;
}

