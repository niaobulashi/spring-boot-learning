package com.niaobulashi.service;

import com.niaobulashi.model.SysUser;

import java.util.List;

/**
 * @program: mybatis_test
 * @description: 用户
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-11 00:33
 */
public interface SysUserService {

    /**
     * 查询用户信息列表1
     */
    List<SysUser> queryUserList1();

    /**
     * 查询用户信息列表2
     */
    List<SysUser> queryUserList2();

    /**
     * 根据用户名模糊查询用户信息
     */
    List<SysUser> queryUserListByName(String userName);

    /**
     * 根据用户名模糊查询用户信息
     */
    List<SysUser> queryUserByNameAndEmail(SysUser user);

    /**
     * 使用用户名和邮箱查询用户信息2
     */
    List<SysUser> queryUserByUser(SysUser user);

    /**
     * 查看用户部门和角色信息
     */
    List<SysUser> queryUserRoleDept(SysUser user);
}
