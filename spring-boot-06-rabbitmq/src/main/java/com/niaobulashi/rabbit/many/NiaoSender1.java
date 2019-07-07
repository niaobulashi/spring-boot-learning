package com.niaobulashi.rabbit.many;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @program: spring-boot-learning
 * @description: 多对多发送端
 * @author: https://niaobulashi.com
 * @create: 2019-05-09 16:37
 **/
@Component
public class NiaoSender1 {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(int i) {
        String context = "spirng boot niaobulashi queue"+" ****** "+i;
        System.out.println("Sender1" + context);
        this.amqpTemplate.convertAndSend("niaobulashi", context);
    }
}

