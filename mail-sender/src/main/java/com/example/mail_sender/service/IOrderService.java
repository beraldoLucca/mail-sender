package com.example.mail_sender.service;

import com.example.mail_sender.dto.OrderDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.CompletableFuture;

public interface IOrderService {

    public void save(OrderDTO dto);

    public CompletableFuture<BigDecimal> getReport(LocalDate date);
}
