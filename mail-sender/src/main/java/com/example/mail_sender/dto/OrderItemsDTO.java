package com.example.mail_sender.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record OrderItemsDTO(@NotNull Long productId, @NotNull @Min(1) Integer quantity) {
}
