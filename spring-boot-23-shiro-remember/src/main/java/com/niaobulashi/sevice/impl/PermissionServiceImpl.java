package com.niaobulashi.sevice.impl;

import com.niaobulashi.mapper.PermissionMapper;
import com.niaobulashi.sevice.PermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: spring-boot-20-shiro
 * @description: 权限
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:55
 */
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionMapper permissionMapper;

    /**
     * 根据角色id查询权限
     * @param roleIds
     * @return
     */
    @Override
    public List<String> findByRoleId(List<Integer> roleIds) {
        return permissionMapper.findByRoleId(roleIds);
    }
}
