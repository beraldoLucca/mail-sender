package com.example.mail_sender.controller;

import com.example.mail_sender.dto.OrderDTO;
import com.example.mail_sender.email.MailOrderAsked;
import com.example.mail_sender.service.IOrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class OrderController {

    private final IOrderService service;

    public OrderController(IOrderService service) {
        this.service = service;
    }

    @PostMapping(value = "order", consumes = "application/json")
    public ResponseEntity<String> order(@RequestBody OrderDTO dto) {
        service.save(dto);
        return ResponseEntity.ok("Order created sucessfully");
    }
}
