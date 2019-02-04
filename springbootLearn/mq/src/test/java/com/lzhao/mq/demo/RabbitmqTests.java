package com.lzhao.mq.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void sendMessageTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "This is the first message");
        map.put("data", Arrays.asList("helloWorld", 123, true));

        rabbitTemplate.convertAndSend("exchange.direct", "lzhao.news", map);
    }

    @Test
    public void receiveMessageTest() {
        Object newsMessage = rabbitTemplate.receiveAndConvert("lzhao.news");
        System.out.println(newsMessage.getClass()); // class java.util.HashMap
        System.out.println(newsMessage); // {msg=This is the first message, data=[helloWorld, 123, true]}
    }
}
