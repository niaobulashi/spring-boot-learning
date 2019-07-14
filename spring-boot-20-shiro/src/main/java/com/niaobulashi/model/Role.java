package com.niaobulashi.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @program: spring-boot-20-shiro
 * @description: 角色
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:51
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = -1767327914553823741L;

    private Integer id;

    private String role;

    private String desc;
}
