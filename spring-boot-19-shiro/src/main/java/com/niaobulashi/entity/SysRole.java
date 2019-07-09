package com.niaobulashi.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-learning
 * @description: 角色表
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-09 22:48
 */
@Data
public class SysRole implements Serializable {

    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;
}
