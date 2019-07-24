package com.niaobulashi.mapper;

import com.niaobulashi.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * @program: spring-boot-20-shiro
 * @description: 用户
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-14 11:47
 */
public interface UserMapper {
    /**
     * 根据账户查询用户信息
     * @param account
     * @return
     */
    User findByAccount(@Param("account") String account);
}
