package com.niaobulashi.rabbit.object;

import com.niaobulashi.model.User;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-learning
 * @description: 对象内容的发送端
 * @author: https://niaobulashi.com
 * @create: 2019-05-09 17:05
 **/
@Component
public class ObjectSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(User user) {
        System.out.println("Sender object: " + user.toString());
        this.amqpTemplate.convertAndSend("object", user);
    }
}

