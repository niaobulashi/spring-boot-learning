package com.niaobulashi.sevice.impl;

import com.niaobulashi.mapper.UserMapper;
import com.niaobulashi.model.User;
import com.niaobulashi.sevice.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @program: spring-boot-20-shiro
 * @description: 用户
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:51
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    @Override
    public User findByAccount(String account) {
        return userMapper.findByAccount(account);
    }
}