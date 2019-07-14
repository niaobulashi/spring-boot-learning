package com.niaobulashi.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-20-shiro
 * @description: 用户
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:51
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -6056125703075132981L;

    private Integer id;

    private String account;

    private String password;

    private String username;
}