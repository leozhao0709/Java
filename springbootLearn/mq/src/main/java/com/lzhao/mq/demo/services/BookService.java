package com.lzhao.mq.demo.services;

import com.lzhao.mq.demo.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
class BookService {

    @RabbitListener(queues = "lzhao.news")
    public void receiveBook(Book book) {
        System.out.println("receive message" + book);
    }

    @RabbitListener(queues = "lzhao.news")
    public void receiveMessage(Message message) {
        System.out.println(message.getBody());
        System.out.println(message.getMessageProperties());
    }
}
