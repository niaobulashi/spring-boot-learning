package com.niaobulashi.service;

import com.niaobulashi.entity.SysUserEntity;

import java.util.List;

/**
 * @program: niaobulashi
 * @description: 系统配置信息
 * @author: https://niaobulashi.com
 * @create: 2019-06-26 21:19
 */
public interface SysUserService {

	/**
	 * 查询所有用户信息
	 */
	List<SysUserEntity> queryUserAll();

	/**
	 * 根据userId查询用户信息
	 */
	List<SysUserEntity> queryUserInfo(Long userId);

	/**
	 * 根据userId更新用户的邮箱和手机号
	 */
	int updateUserInfo(SysUserEntity user);
}
