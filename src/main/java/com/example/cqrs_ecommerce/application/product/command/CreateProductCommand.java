package com.example.cqrs_ecommerce.application.product.command;

import com.example.cqrs_ecommerce.application.product.dto.CreatedProductResponse;
import com.example.cqrs_ecommerce.core.cqrs.Command;

import java.math.BigDecimal;

public record CreateProductCommand(
        String name, String description, BigDecimal price,
        String currency, Integer stock
) implements Command<CreatedProductResponse> {


}
