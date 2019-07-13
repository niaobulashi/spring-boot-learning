package com.niaobulashi.model;

import java.io.Serializable;

/**
 * @program: mybatis_test
 * @description: 部门表
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-13 00:00
 */
public class SysDept implements Serializable {

    /** 部门ID */
    private Long deptId;

    /** 部门名称 */
    private String deptName;

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
