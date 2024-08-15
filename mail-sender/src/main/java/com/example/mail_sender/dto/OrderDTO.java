package com.example.mail_sender.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record OrderDTO (@NotNull @Valid List<OrderItemsDTO> items){}
