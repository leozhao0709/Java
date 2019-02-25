package com.lzhao.jpa.entity;

import com.lzhao.jpa.repository.CustomerRepository;
import com.lzhao.jpa.repository.OrderRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAndOrderTest {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void oneToManyInsert() {
        Customer customer = new Customer("cc", "cc@163.com", 18, LocalDateTime.now(), LocalDate.now());

        Order order1 = new Order("O-CC-1", customer);
        Order order2 = new Order("O-CC-2", customer);

        Set<Order> orderSet = new HashSet<>();
        orderSet.add(order1);
        orderSet.add(order2);
        customer.setOrders(orderSet);

        customerRepository.save(customer);
        orderRepository.save(order1);
        orderRepository.save(order2);
    }

    @Test
    @Transactional
    public void oneToManySelect() {
//        Optional<Order> order1 = orderRepository.findById(5);
//        order1.ifPresent(order -> {
//            System.out.println(order);
//            Customer customer = order.getCustomer();
//            System.out.println(customer);
//        });

        Order order1 = orderRepository.getOne(5);
        System.out.println(order1);
        System.out.println(order1.getCustomer());
    }
}
