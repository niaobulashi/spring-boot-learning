package com.niaobulashi.dao;

import com.niaobulashi.model.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: niaobulashi
 * @description: 系统用户
 * @author: https://niaobulashi.com
 * @create: 2019-07-10 21:19
 */
public interface SysUserDao {
	
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
	 * @param userName 用户名
	 * @return	用户数据集合信息
	 */
	List<SysUser> queryUserListByName(String userName);

	/**
	 * 使用用户名和邮箱查询用户信息
	 * @param userName	用户名
	 * @param email		邮箱
	 * @return	用户数据集合信息
	 */
	List<SysUser> queryUserByNameAndEmail(@Param("userName") String userName, @Param("email") String email);

	/**
	 * 使用用户名和邮箱查询用户信息2
	 *
	 * @param sysUser 字典数据信息
	 * @return 用户数据集合信息
	 */
	List<SysUser> queryUserByUser(SysUser sysUser);

	/**
	 * 查看用户部门和角色信息
	 * @param user
	 * @return
	 */
	List<SysUser> queryUserRoleDept(SysUser user);
}
