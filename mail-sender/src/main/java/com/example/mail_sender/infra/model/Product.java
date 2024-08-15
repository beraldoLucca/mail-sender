package com.example.mail_sender.infra.model;

import com.example.mail_sender.dto.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

    @Setter
    private BigDecimal price;

    @Getter
    @Setter
    private Integer quantity;

    public static Product of(ProductDTO dto){
        var product = new Product();
        BeanUtils.copyProperties(dto, product);
        return product;
    }
}
