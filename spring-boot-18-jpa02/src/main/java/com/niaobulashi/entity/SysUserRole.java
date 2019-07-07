package com.niaobulashi.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: https://niaobulashi.com
 * @create: 2019-07-07 12:38
 */
@Entity
@Data
@Table(name = "sys_user_role")
public class SysUserRole implements Serializable {

    @Id
    @GeneratedValue
    private int id;

    /**
     * 用户ID
     */
    private String userId;

    /**
     * 角色ID
     */
    private int roleId;
}
