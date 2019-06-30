package com.niaobulashi.dao;

import com.niaobulashi.entity.SysCodeEntity;

import java.util.List;

/**
 * @program: spring-boot-learning
 * @description: 数字字典
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-06-30 10:40
 */
public interface SysCodeDao {

    /**
     * 查询所有数字字典
     */
    List<SysCodeEntity> queryCodeAll();

}
