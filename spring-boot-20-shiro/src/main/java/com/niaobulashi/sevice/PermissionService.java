package com.niaobulashi.sevice;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: spring-boot-20-shiro
 * @description: 权限
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:54
 */
public interface PermissionService {

    /**
     * 根据角色id查询权限
     * @param roleIds
     * @return
     */
    List<String> findByRoleId(@Param("roleIds") List<Integer> roleIds);
}
