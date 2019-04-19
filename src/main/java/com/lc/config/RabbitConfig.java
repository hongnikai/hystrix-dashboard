package com.lc.config;

import com.lc.controller.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Configuration
public class RabbitConfig {

//创建一个名为hello的消息队列。
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }






}
