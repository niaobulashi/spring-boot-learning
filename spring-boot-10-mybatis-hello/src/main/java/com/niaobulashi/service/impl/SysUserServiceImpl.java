package com.niaobulashi.service.impl;

import com.niaobulashi.dao.SysUserDao;
import com.niaobulashi.entity.SysUserEntity;
import com.niaobulashi.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: niaobulashi
 * @description: 系统用户
 * @author: https://niaobulashi.com
 * @create: 2019-06-26 21:19
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 查询用户的所有菜单ID
	 * @param userId
	 * @return
	 */
	@Override
	public List<SysUserEntity> queryUserInfo(Long userId) {
		return sysUserDao.queryUserInfo(userId);
	}
}
