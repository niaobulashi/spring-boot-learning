package com.niaobulashi.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @program: niaobulashi
 * @description: 系统用户
 * @author: https://niaobulashi.com
 * @create: 2019-06-26 21:19
 */
public class SysUser implements Serializable {
	private static final long serialVersionUID = 1L;

	/** 用户ID */
	private Long userId;

	/** 用户名 */
	private String userNameStr;

	/** 密码 */
	private String password;

	/** 盐 */
	private String salt;

	/** 邮箱 */
	private String email;

	/** 手机号 */
	private String mobile;

	/** 状态  0：禁用   1：正常 */
	private Integer status;

	/** 部门Id */
	private Long deptId;

	/** 创建时间 */
	private Date createTime;

	/** 金额 */
	private BigDecimal amt;

	/** 修改日期 */
	private Date updateDate;

	/****************关联部分**************
	/** 部门 */
	private SysDept dept;

	/** 角色集合 */
	private List<SysRole> roles;

	/** 创建开始日期 */
	private String createDateStart;

	/** 创建结束日期 */
	private String createDateEnd;

	/** 起始金额 */
	private BigDecimal amtFrom;

	/** 截至金额 */
	private BigDecimal amtTo;

	/** 修改时间开始 */
	private String updateDateStart;

	/** 修改时间结束 */
	private String updateDateEnd;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserNameStr() {
		return userNameStr;
	}

	public void setUserNameStr(String userNameStr) {
		this.userNameStr = userNameStr;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getDeptId() {
		return deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public SysDept getDept() {
		return dept;
	}

	public void setDept(SysDept dept) {
		this.dept = dept;
	}

	public List<SysRole> getRoles() {
		return roles;
	}

	public void setRoles(List<SysRole> roles) {
		this.roles = roles;
	}

	public String getCreateDateStart() {
		return createDateStart;
	}

	public void setCreateDateStart(String createDateStart) {
		this.createDateStart = createDateStart;
	}

	public String getCreateDateEnd() {
		return createDateEnd;
	}

	public void setCreateDateEnd(String createDateEnd) {
		this.createDateEnd = createDateEnd;
	}

	public BigDecimal getAmt() {
		return amt;
	}

	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}

	public BigDecimal getAmtFrom() {
		return amtFrom;
	}

	public void setAmtFrom(BigDecimal amtFrom) {
		this.amtFrom = amtFrom;
	}

	public BigDecimal getAmtTo() {
		return amtTo;
	}

	public void setAmtTo(BigDecimal amtTo) {
		this.amtTo = amtTo;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateDateStart() {
		return updateDateStart;
	}

	public void setUpdateDateStart(String updateDateStart) {
		this.updateDateStart = updateDateStart;
	}

	public String getUpdateDateEnd() {
		return updateDateEnd;
	}

	public void setUpdateDateEnd(String updateDateEnd) {
		this.updateDateEnd = updateDateEnd;
	}
}
