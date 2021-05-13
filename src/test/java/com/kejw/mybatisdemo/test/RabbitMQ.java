package com.kejw.mybatisdemo.test;

import com.kejw.mybatisdemo.MybatisDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MybatisDemoApplication.class)
@RunWith(SpringRunner.class)
public class RabbitMQ {

    // 注入rabbitTemplate
    @Autowired
    private RabbitTemplate rabbitTemplate;

    // topic 模式
    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save 的路由消息");
        rabbitTemplate.convertAndSend("topics","order.yanzhe.tkjw","tkjw 的路由消息");
    }


    // 路由模式
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("dd","error","发送的info的路由信息");
    }


    // fanout 广播
    @Test
    public void testFanOut(){
        rabbitTemplate.convertAndSend("ls","","Fanout的模型发送的消息");
    }

    @Test
    public void testWork(){
        rabbitTemplate.convertAndSend("work","work模型1");
        rabbitTemplate.convertAndSend("work","work模型2");
    }


    // hello world
    @Test
    public void test(){
        rabbitTemplate.convertAndSend("hello"," hello world");
    }

}
