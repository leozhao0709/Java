package com.lzhao.jpa.entity;

import com.lzhao.jpa.repository.CustomerRepository;
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
public class CustomerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void insertNewCustomer() {
        Customer customer = new Customer("Tom", "tom@atguigu.com", 12, LocalDateTime.now(), LocalDate.now());
        customerRepository.save(customer);
    }
}