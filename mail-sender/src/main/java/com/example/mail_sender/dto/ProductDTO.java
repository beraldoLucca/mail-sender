package com.example.mail_sender.dto;

import java.math.BigDecimal;

public record ProductDTO(String name, String description, BigDecimal price, Integer quantity) {
}
