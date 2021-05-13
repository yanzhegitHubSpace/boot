package com.kejw.mybatisdemo.test.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = "topic", name="topics"),
                    key = {"user.save","user.*"}
            )
    })
    public void receive1(String message){
        System.err.println("message1 = " + message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(type = "topic", name="topics"),
                    key = {"order.#","user.*","produce.#"}
            )
    })
    public void receive2(String message){
        System.err.println("message2 = " + message);
    }

}
