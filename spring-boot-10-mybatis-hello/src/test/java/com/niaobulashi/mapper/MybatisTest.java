package com.niaobulashi.mapper;

import com.niaobulashi.entity.SysUserEntity;
import com.niaobulashi.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @program: mybatis_01_hello
 * @description: 测试类
 * @author: hulang  hulang6666@qq.com
 * @create: 2019-06-26 16:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisTest {
    private Logger logger = LoggerFactory.getLogger(MybatisTest.class);

    @Autowired
    private SysUserService sysUserService;

    @Test
    public void queryUserInfo() throws Exception {
        SysUserEntity userEntity = new SysUserEntity();
        userEntity.setUserId(1L);
        List<SysUserEntity> list = sysUserService.queryUserInfo(userEntity.getUserId());
        logger.info("list:" + list);
    }

}

