package com.niaobulashi.sevice;

import com.niaobulashi.model.Role;

import java.util.List;

/**
 * @program: spring-boot-20-shiro
 * @description: 角色
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:49
 */
public interface RoleService {

    /**
     *
     * @param id
     * @return
     */
    List<Role> findRoleByUserId(Integer id);
}
