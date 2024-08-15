package com.example.mail_sender.controller;

import com.example.mail_sender.dto.ProductDTO;
import com.example.mail_sender.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {

    private final IProductService service;

    public ProductController(IProductService service) {
        this.service = service;
    }

    @PostMapping("products")
    public ResponseEntity<String> save(@RequestBody ProductDTO dto) {
        service.save(dto);
        return ResponseEntity.ok("Product created");

    }
}
