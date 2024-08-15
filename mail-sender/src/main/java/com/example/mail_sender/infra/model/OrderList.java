package com.example.mail_sender.infra.model;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "order_list")
public class OrderList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @Setter
    @ManyToOne
    private Order order;

    private Integer quantity;

    public OrderList(Product product, Integer quantity, Order order) {
        this.product = product;
        this.quantity = quantity;
        this.order = order;
    }

    public OrderList() {}
}
