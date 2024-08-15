package com.example.mail_sender.controller;

import com.example.mail_sender.infra.db.IOrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;

@RestController
@RequestMapping("/")
public class ReportController {

    private final IOrderRepository repository;

    public ReportController(IOrderRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<BigDecimal> getReport() {
        var income = repository.dailyIncome(LocalDate.now());
        return ResponseEntity.ok().body(income);
    }
}
