package com.niaobulashi.dao;

import com.niaobulashi.entity.SysUserEntity;

import java.util.List;

/**
 * @program: niaobulashi
 * @description: 系统用户
 * @author: https://niaobulashi.com
 * @create: 2019-06-26 21:19
 */
public interface SysUserDao {
	
	/**
	 * 根据userId查询用户信息
	 * @param userId  用户ID
	 */
	List<SysUserEntity> queryUserInfo(Long userId);

	/**
	 * 查询所有用户信息
	 */
	List<SysUserEntity> queryUserAll();

	/**
	 * 根据userId更新用户的邮箱和手机号
	 * @return
	 */
	int updateUserInfo(SysUserEntity user);

}
