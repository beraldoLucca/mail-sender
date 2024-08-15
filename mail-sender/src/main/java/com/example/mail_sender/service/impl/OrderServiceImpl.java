package com.example.mail_sender.service.impl;

import com.example.mail_sender.dto.OrderDTO;
import com.example.mail_sender.infra.db.IOrderRepository;
import com.example.mail_sender.infra.db.IProductRepository;
import com.example.mail_sender.infra.model.Order;
import com.example.mail_sender.infra.model.OrderList;
import com.example.mail_sender.service.IOrderService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository orderRepository;

    private final IProductRepository productRepository;

    public OrderServiceImpl(IOrderRepository orderRepository, IProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }


    @Override
    public void save(OrderDTO dto) {
        var orderList = new ArrayList<OrderList>();
        dto.items().forEach(prod -> {
            var product = productRepository.findById(prod.productId()).get();
            if(product.getQuantity() < prod.quantity())
                throw new RuntimeException("Quantity product is not available.");
            var newOrderList = new OrderList(product, prod.quantity(), null);
            orderList.add(newOrderList);
        });

        var order = new Order(orderList);
        orderRepository.save(order);
    }

    @Override
    @Async
    public CompletableFuture<BigDecimal> getReport(LocalDate date){
        return CompletableFuture.completedFuture(orderRepository.dailyIncome(date));
    }
}
