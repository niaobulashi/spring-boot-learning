package com.niaobulashi.rabbitmq;

import com.niaobulashi.rabbit.many.NiaoSender1;
import com.niaobulashi.rabbit.many.NiaoSender2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: spring-boot-learning
 * @description: 多对多队列
 * @author: https://niaobulashi.com
 * @create: 2019-05-09 16:50
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ManyTest {

    @Autowired
    private NiaoSender1 niaoSender1;

    @Autowired
    private NiaoSender2 niaoSender2;

    @Test
    public void oneToMany() throws Exception {
        for (int i = 0; i < 20; i++) {
            niaoSender1.send(i);
        }
    }

    @Test
    public void manyToMany() throws Exception {
        for (int i = 0; i < 50; i++) {
            niaoSender1.send(i);
            niaoSender2.send(i);
        }
    }

}

