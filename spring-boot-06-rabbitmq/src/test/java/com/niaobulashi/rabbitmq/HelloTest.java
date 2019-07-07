package com.niaobulashi.rabbitmq;

import com.niaobulashi.rabbit.hello.HelloSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: spring-boot-learning
 * @description: hello测试类
 * @author: https://niaobulashi.com
 * @create: 2019-05-09 16:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloTest {

    @Autowired
    private HelloSender helloSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }
}

