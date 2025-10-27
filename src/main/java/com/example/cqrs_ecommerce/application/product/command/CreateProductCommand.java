package com.example.cqrs_ecommerce.application.product.command;

import com.example.cqrs_ecommerce.application.product.dto.CreatedProductResponse;
import com.example.cqrs_ecommerce.core.cqrs.Command;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CreateProductCommand(
        @NotBlank @Size(min=3, max = 255) String name,
        @NotBlank @Size(min=3, max = 255) String description,
        @Positive BigDecimal price,
        @NotBlank @Size(min = 2, max = 255) String currency,
        @Min(0) Integer stock
) implements Command<CreatedProductResponse> { //marker interface




}
