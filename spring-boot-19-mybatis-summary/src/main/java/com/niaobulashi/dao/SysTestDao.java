package com.niaobulashi.dao;

import com.niaobulashi.model.SysTest;

/**
 * @program: mybatis_test
 * @description: 测试
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-10 22:17
 */
public interface SysTestDao {

    /**
     * 新增
     */
    int insertSysTest(SysTest sysTest);

    /**
     * 批量删除
     */
    int deleteSysTestByIds(String[] ids);
}
