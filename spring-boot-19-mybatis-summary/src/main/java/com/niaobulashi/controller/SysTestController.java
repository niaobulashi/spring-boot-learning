package com.niaobulashi.controller;

import com.niaobulashi.model.SysTest;
import com.niaobulashi.service.SysTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: mybatis_test
 * @description: 测试
 * @author: 鸟不拉屎 https://niaobulashi.com
 * @create: 2019-07-10 22:18
 */
@Slf4j
@RestController
@RequestMapping("/test")
public class SysTestController {

    @Autowired
    private SysTestService sysTestService;


    /**
     * 获取自增长主键ID
     * @param sysTest
     * @throws Exception
     */
    // 请求post：127.0.0.1:8081/test/add
    /*
    {
        "name":"Yoo",
        "age":18,
        "nickName":"3"
    }
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private void addSysTest(@RequestBody SysTest sysTest) throws Exception {
        try {
            SysTest sysTestParam = new SysTest();
            // 将传入参数Copy到新申明的对象中，这样才能从sysTestParam中获取到自增长主键
            BeanUtils.copyProperties(sysTest, sysTestParam);
            this.sysTestService.insertSysTest(sysTestParam);
            log.info("获取自增长主键为：" + sysTestParam.getId());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }

    /**
     * 批量删除
     * @return
     */
    @RequestMapping(value = "/deleteIds", method = RequestMethod.POST)
    public int deleteIds(String ids) throws Exception {
        try {
            return sysTestService.deleteDictDataByIds(ids);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}
