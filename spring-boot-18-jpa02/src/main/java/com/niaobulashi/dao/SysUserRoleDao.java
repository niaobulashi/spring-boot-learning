package com.niaobulashi.dao;

import com.niaobulashi.entity.SysUserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: https://niaobulashi.com
 * @create: 2019-07-07 13:22
 */
public interface SysUserRoleDao extends JpaRepository<SysUserRole, Integer> {
}
