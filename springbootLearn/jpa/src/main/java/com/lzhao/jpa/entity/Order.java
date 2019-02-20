package com.lzhao.jpa.entity;

import javax.persistence.*;

@Table(name = "JPA_ORDERS")
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String orderName;
    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;


    public Order() {
    }

    public Order(String orderName, Customer customer) {
        this.orderName = orderName;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
