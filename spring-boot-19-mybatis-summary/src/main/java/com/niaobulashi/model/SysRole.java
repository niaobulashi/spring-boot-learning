package com.niaobulashi.model;

import java.io.Serializable;

/**
 * @program: mybatis_test
 * @description: 角色表
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-12 22:22
 */
public class SysRole implements Serializable {

    /** 角色ID */
    private Long roleId;

    /** 角色名称 */
    private String roleName;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
