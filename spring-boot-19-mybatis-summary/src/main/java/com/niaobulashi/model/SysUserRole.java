package com.niaobulashi.model;

import java.io.Serializable;

/**
 * @program: mybatis_test
 * @description: 用户角色对照表
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-12 22:32
 */
public class SysUserRole implements Serializable {

    /** 用户ID */
    private Long userId;

    /** 角色ID */
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
