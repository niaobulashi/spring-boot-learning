package com.niaobulashi.rabbitmq;

import com.niaobulashi.model.User;
import com.niaobulashi.rabbit.object.ObjectSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @program: spring-boot-learning
 * @description: 对象内容的消息队列
 * @author: https://niaobulashi.com
 * @create: 2019-05-09 17:20
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObjectTest {

    @Autowired
    private ObjectSender objectSender;

    @Test
    public void objectSend() {
        User user = new User();
        user.setName("小明");
        user.setPass("123321");
        objectSender.send(user);
    }
}

