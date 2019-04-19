package com.lc.simple;

import com.lc.util.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/*
*
* 消费者  获取消息
*
* */
public class Receive {

    //测试普通队列
    private static final String QUEUE_NAME="test_simple_queue";

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {

        //获取链接
        Connection connection = ConnectionUtil.getConnection();

        //创建频道
        Channel channel = connection.createChannel();

        //定义队列的消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //监听队列
        channel.basicConsume(QUEUE_NAME,true,queueingConsumer);

        while(true){

            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();

            String msgString =new String(delivery.getBody());

            System.out.println("{recv} msg:"+msgString);

        }




    }


}
