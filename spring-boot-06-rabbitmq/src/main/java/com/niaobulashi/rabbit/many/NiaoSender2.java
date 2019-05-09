package com.niaobulashi.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-learning
 * @description: 多对多发送端
 * @author: hulang
 * @create: 2019-05-09 16:37
 **/
@Component
public class NiaoSender2 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        String context = "spirng boot niaobulashi queue"+" ****** "+i;
        System.out.println("Sender2" + context);
        this.amqpTemplate.convertAndSend("niaobulashi", context);
    }
}

