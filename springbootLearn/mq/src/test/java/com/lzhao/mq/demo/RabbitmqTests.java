package com.lzhao.mq.demo;

import com.lzhao.mq.demo.bean.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
    @Autowired
    private AmqpAdmin amqpAdmin;

    @Test
    public void createExchangeAndQueueAndBinding() {
        // create exchange
        amqpAdmin.declareExchange(new DirectExchange("test.exchange"));

        // create queue
        amqpAdmin.declareQueue(new Queue("test.queue"));

        // binding queue and exchange
        amqpAdmin.declareBinding(new Binding("test.queue", Binding.DestinationType.QUEUE, "test.exchange", "test.routingKey", null));
    }

    @Test
    public void sendMessageTest() {
        Map<String, Object> map = new HashMap<>();
        map.put("msg", "This is the first message");
        map.put("data", Arrays.asList("helloWorld", 123, true));

        rabbitTemplate.convertAndSend("exchange.direct", "lzhao.news", map);
    }

    @Test
    public void sendObjectTest() {
        Book book = new Book("西游记", "吴承恩");
        rabbitTemplate.convertAndSend("exchange.direct", "lzhao.news", book);
    }

    @Test
    public void receiveMessageTest() {
        Object newsMessage = rabbitTemplate.receiveAndConvert("lzhao.news");
        System.out.println(newsMessage.getClass()); // class java.util.HashMap
        System.out.println(newsMessage); // {msg=This is the first message, data=[helloWorld, 123, true]}
    }
}
