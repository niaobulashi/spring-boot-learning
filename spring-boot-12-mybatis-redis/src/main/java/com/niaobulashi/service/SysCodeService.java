package com.niaobulashi.service;

import com.niaobulashi.entity.SysCodeEntity;

import java.util.List;

/**
 * @program: spring-boot-learning
 * @description: 数字字典
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-06-30 10:18
 */
public interface SysCodeService {

    /**
     * 查询所有数字字典
     */
    List<SysCodeEntity> queryCodeAll();
}
