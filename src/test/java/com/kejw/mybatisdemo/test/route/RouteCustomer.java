package com.kejw.mybatisdemo.test.route;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RouteCustomer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "dd", type = "direct"), //指定交换机名称和类型
                    key = {"info","error","warning"}
            )
    })
    public void receive1(String message){
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "dd", type = "direct"), //指定交换机名称和类型
                    key = {"info"}
            )
    })
    public void receive2(String message){
        System.out.println("message2 = " + message);
    }

}
