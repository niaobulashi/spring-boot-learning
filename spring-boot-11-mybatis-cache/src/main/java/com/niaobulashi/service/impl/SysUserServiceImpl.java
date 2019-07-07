package com.niaobulashi.service.impl;

import com.niaobulashi.dao.SysUserDao;
import com.niaobulashi.entity.SysUserEntity;
import com.niaobulashi.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: niaobulashi
 * @description: 系统用户
 * @author: https://niaobulashi.com
 * @create: 2019-06-28 21:19
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

	private Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

	@Autowired
	private SysUserDao sysUserDao;

	/**
	 * 查询所有用户信息
	 */
	@Override
	public List<SysUserEntity> queryUserAll() {
		return sysUserDao.queryUserAll();
	}

	/**
	 * 根据userId查询用户信息
	 */
	@Override
	public List<SysUserEntity> queryUserInfo(Long userId) {
		return sysUserDao.queryUserInfo(userId);
	}

	/**
	 * 根据userId更新用户的邮箱和手机号
	 */
	@Override
	public int updateUserInfo(SysUserEntity user) {
		return sysUserDao.updateUserInfo(user);
	}
}
