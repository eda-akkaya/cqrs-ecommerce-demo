package com.example.cqrs_ecommerce.application.product.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record ProductResponse(
        UUID id, String name, String description,
        BigDecimal price, String currency, Integer stock
) {


}
