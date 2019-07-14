package com.niaobulashi.mapper;

import com.niaobulashi.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: spring-boot-20-shiro
 * @description: 角色
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 09:30
 */
public interface RoleMapper {

    /**
     * 根据userId查询
     * @param userId
     * @return
     */
    List<Role> findRoleByUserId(@Param("userId") Integer userId);
}
