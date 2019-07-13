package com.niaobulashi.service.impl;

import com.niaobulashi.dao.SysUserDao;
import com.niaobulashi.model.SysUser;
import com.niaobulashi.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: mybatis_test
 * @description: 用户
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-11 00:33
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    /**
     * 查询用户信息列表1
     */
    @Override
    public List<SysUser> queryUserList1() {
        return sysUserDao.queryUserList1();
    }

    /**
     * 查询用户信息列表2
     * @return
     */
    @Override
    public List<SysUser> queryUserList2() {
        return sysUserDao.queryUserList2();
    }

    /**
     * 根据用户名模糊查询用户信息
     */
    @Override
    public List<SysUser> queryUserListByName(String userName) {
        return sysUserDao.queryUserListByName(userName);
    }

    /**
     * 根据用户名模糊查询用户信息
     */
    @Override
    public List<SysUser> queryUserByNameAndEmail(SysUser user) {
        return sysUserDao.queryUserByNameAndEmail(user.getUserNameStr(), user.getEmail());
    }

    /**
     * 使用用户名和邮箱查询用户信息2
     */
    @Override
    public List<SysUser> queryUserByUser(SysUser user) {
        return sysUserDao.queryUserByUser(user);
    }

    /**
     * 查看用户部门和角色信息
     */
    @Override
    public List<SysUser> queryUserRoleDept(SysUser user) {
        return sysUserDao.queryUserRoleDept(user);
    }

}
