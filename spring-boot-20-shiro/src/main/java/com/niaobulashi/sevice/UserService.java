package com.niaobulashi.sevice;

import com.niaobulashi.model.User;

/**
 * @program: spring-boot-20-shiro
 * @description: 用户
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:49
 */
public interface UserService {

    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    User findByAccount(String account);
}