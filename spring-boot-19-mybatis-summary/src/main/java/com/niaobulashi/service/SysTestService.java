package com.niaobulashi.service;

import com.niaobulashi.model.SysTest;

/**
 * @program: mybatis_test
 * @description: 测试
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-10 22:54
 */
public interface SysTestService {

    void insertSysTest(SysTest sysTest) throws Exception;

    /**
     * 批量删除
     */
    int deleteDictDataByIds(String ids) throws Exception;
}
