package com.example.mail_sender.infra.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    private List<OrderList> orderList = new ArrayList<>();

    private LocalDate orderDate;

    public Order() {}

    public Order(List<OrderList> orderList) {
        this.orderList = orderList;
        this.orderList.forEach(o -> o.setOrder(this));
        this.orderDate = LocalDate.now();
    }
}
