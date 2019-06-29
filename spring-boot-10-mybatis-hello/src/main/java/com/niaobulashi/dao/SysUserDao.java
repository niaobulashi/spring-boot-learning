package com.niaobulashi.dao;

import com.niaobulashi.entity.SysUserEntity;

import java.util.List;

/**
 * @program: niaobulashi
 * @description: 系统用户
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-06-26 21:19
 */
public interface SysUserDao {
	
	/**
	 * 根据userId查询用户信息
	 * @param userId  用户ID
	 */
	List<SysUserEntity> queryUserInfo(Long userId);

}
