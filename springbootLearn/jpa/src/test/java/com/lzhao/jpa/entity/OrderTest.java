package com.lzhao.jpa.entity;

import com.lzhao.jpa.repository.CustomerRepository;
import com.lzhao.jpa.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTest {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void manyToOne() {
        Customer customer = new Customer("BB", "tom@atguigu.com", 12, LocalDateTime.now(), LocalDate.now());
        Order order1 = new Order("B-BB-1", customer);
        Order order2 = new Order("B-BB-2", customer);

        customerRepository.save(customer);
        orderRepository.save(order1);
        orderRepository.save(order2);
    }
}