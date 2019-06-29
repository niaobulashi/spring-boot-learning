package com.niaobulashi.service;

import com.niaobulashi.entity.SysUserEntity;

import java.util.List;

/**
 * @program: niaobulashi
 * @description: 系统配置信息
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-06-26 21:19
 */
public interface SysUserService {
	/**
	 * 查询用户的所有菜单ID
	 */
	List<SysUserEntity> queryUserInfo(Long userId);
}
