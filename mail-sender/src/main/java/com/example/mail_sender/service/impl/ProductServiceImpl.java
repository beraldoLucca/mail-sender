package com.example.mail_sender.service.impl;

import com.example.mail_sender.dto.ProductDTO;
import com.example.mail_sender.infra.db.IProductRepository;
import com.example.mail_sender.infra.model.Product;
import com.example.mail_sender.service.IProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;

    public ProductServiceImpl(IProductRepository productRepository) {
        this.repository = productRepository;
    }

    @Override
    public void save(ProductDTO dto) {
        var product = Product.of(dto);
        repository.save(product);
    }
}
