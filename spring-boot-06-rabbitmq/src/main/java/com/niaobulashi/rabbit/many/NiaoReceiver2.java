package com.niaobulashi.rabbit.many;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-learning
 * @description: 多对多队列
 * @author: https://niaobulashi.com
 * @create: 2019-05-09 16:46
 **/
@Component
@RabbitListener(queues = "niaobulashi")
public class NiaoReceiver2 {

    @RabbitHandler
    public void process(String niaobulashi) {
        System.out.println("Receiver 2: " + niaobulashi);
    }
}

