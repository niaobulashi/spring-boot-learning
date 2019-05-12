package com.niaobulashi.rabbit;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: spring-boot-learning
 * @description: 队列配置
 * @author: hulang
 * @create: 2019-05-09 16:20
 **/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue manyQueue() {
        return new Queue("niaobulashi");
    }

    @Bean
    public Queue objectQueue() {
        return new Queue("object");
    }
}

