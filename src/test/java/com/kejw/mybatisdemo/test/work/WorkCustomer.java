package com.kejw.mybatisdemo.test.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkCustomer {

    // 第一个消费者
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive1(String message) {
        System.err.println("message1 = " + message);
    }

    // 第二个消费者
    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void receive2(String message) {
        System.err.println("message2 = " + message);
    }
}
