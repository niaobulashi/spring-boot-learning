package com.niaobulashi.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: niaobulashi
 * @description: 系统用户
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-06-26 21:19
 */
@Data
public class SysUserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	//用户ID
	private Long userId;

	//用户名
	private String username;

	//密码
	private String password;

	//盐
	private String salt;

	//邮箱
	private String email;

	//手机号
	private String mobile;

	//状态  0：禁用   1：正常
	private Integer status;
	
	//创建时间
	private Date createTime;
}
