package com.niaobulashi.japtest;

import com.niaobulashi.dao.SysUserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: spring-boot-learning
 * @description:
 * @author: hulang    hulang6666@qq.com
 * @create: 2019-07-07 02:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

    @Autowired
    private SysUserDao accountDao;

    @Test
    public void initDate() {
    }

    @Test
    public void getAccountList() {
        accountDao.findAll();
    }
}
