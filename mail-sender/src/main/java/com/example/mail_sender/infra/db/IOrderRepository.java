package com.example.mail_sender.infra.db;

import com.example.mail_sender.infra.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface IOrderRepository extends JpaRepository<Order, Long> {

    @Query("""
        SELECT SUM(ol.quantity * p.price)
        FROM Order o
        JOIN o.orderList ol
        JOIN ol.product p
        WHERE o.orderDate= :time
        """)
    BigDecimal dailyIncome(LocalDate time);
}
