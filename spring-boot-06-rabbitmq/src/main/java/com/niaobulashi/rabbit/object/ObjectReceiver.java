package com.niaobulashi.rabbit.object;

import com.niaobulashi.model.User;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @program: spring-boot-learning
 * @description: object接收端
 * @author: https://niaobulashi.com
 * @create: 2019-05-09 17:18
 **/
@Component
@RabbitListener(queues = "object")
public class ObjectReceiver {

    @RabbitHandler
    public void proccess(User user) {
        System.out.println("Receiver object: " + user);
    }
}

