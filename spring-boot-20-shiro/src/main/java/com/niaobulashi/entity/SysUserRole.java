package com.niaobulashi.entity;


import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-learning
 * @description: 用户角色对应表
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-09 22:49
 */
@Data
public class SysUserRole implements Serializable {

    /* 用户Id */
    private Long userId;

    /* 角色Id */
    private Long roleId;
}
