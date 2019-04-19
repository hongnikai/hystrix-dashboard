package com.lc.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver:"+msg);
    }

    //@RabbitListener(queues = “hello”)注解表示该消息消费者监听hello这个消息队列，
    // @RabbitHandler注解则表示process方法是用来处理接收到的消息的，我们这里收到消息后直接打印即可。

}
