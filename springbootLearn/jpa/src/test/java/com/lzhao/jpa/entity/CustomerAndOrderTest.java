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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerAndOrderTest {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    public void oneToManyInsert() {
        Customer customer = new Customer("bb", "bb@163.com", 18, LocalDateTime.now(), LocalDate.now());

        Order order1 = new Order("O-BB-1", customer);
        Order order2 = new Order("O-BB-2", customer);

        List<Order> orderList = Arrays.asList(order1, order2);
        customer.setOrders(orderList);

        customerRepository.save(customer);
        orderRepository.save(order1);
        orderRepository.save(order2);
    }

    @Test
    @Transactional
    public void oneToManySelect() {
        Optional<Order> order1 = orderRepository.findById(5);
        order1.ifPresent(order -> {
            System.out.println(order);
            Customer customer = order.getCustomer();
            System.out.println(customer);
        });
    }
}
