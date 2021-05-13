package com.kejw.mybatisdemo.test.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Customer {

    private static Logger logger = LoggerFactory.getLogger(Customer.class);

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "ls",type = "fanout") // 绑定的交换机
            )
    })
    public void receive1(String message){
        logger.error("message1 = " + message);
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue, // 创建临时队列
                    exchange = @Exchange(value = "ls",type = "fanout") // 绑定的交换机
            )
    })
    public void receive2(String message){
        logger.error("message2 = " + message);
        System.out.println("message2 = " + message);
    }

}
