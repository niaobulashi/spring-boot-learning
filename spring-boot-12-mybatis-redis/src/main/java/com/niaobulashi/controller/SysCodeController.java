package com.niaobulashi.controller;

import com.niaobulashi.entity.SysCodeEntity;
import com.niaobulashi.service.SysCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: spring-boot-12-mybatis-redis
 * @description: 数字字典
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-06-30 13:47
 */
@RestController
public class SysCodeController {

    @Autowired
    private SysCodeService sysCodeService;

    /**
     * 查询所有数字字典
     * @return
     */
    @RequestMapping("/getAll")
    private List<SysCodeEntity> getUser() {
        Long startTime = System.currentTimeMillis(); //开始时间
        List<SysCodeEntity> codeList = sysCodeService.queryCodeAll();
        Long endTime = System.currentTimeMillis(); //结束时间
        System.out.println("共耗时：" + (endTime - startTime) + "毫秒"); //1007毫秒
        return codeList;
    }
}
