package com.niaobulashi.service.impl;

import com.niaobulashi.dao.SysTestDao;
import com.niaobulashi.model.SysTest;
import com.niaobulashi.service.SysTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: mybatis_test
 * @description: 测试
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-10 22:54
 */
@Service("sysTestService")
public class SysTestServiceImpl implements SysTestService {

    @Autowired
    private SysTestDao sysTestDao;


    /**
     * 新增测试数据
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public void insertSysTest(SysTest sysTest) throws Exception {
        try {
            sysTestDao.insertSysTest(sysTest);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    /**
     * 批量删除
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteDictDataByIds(String ids) throws Exception{
        try {
            return sysTestDao.deleteSysTestByIds(ids.split(","));
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
