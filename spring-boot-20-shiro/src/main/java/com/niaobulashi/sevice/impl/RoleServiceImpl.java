package com.niaobulashi.sevice.impl;

import com.niaobulashi.mapper.RoleMapper;
import com.niaobulashi.model.Role;
import com.niaobulashi.sevice.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: spring-boot-20-shiro
 * @description: 角色
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:51
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 根据userId查询
     * @param id
     * @return
     */
    @Override
    public List<Role> findRoleByUserId(Integer id) {
        return roleMapper.findRoleByUserId(id);
    }
}
