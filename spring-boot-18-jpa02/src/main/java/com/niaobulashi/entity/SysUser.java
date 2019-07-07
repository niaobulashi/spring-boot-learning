package com.niaobulashi.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: https://niaobulashi.com
 * @create: 2019-07-07 01:58
 */
@Data
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable {

    @Id
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String passWord;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String salt;

    @Column(nullable = false)
    private Date regTime;

}
