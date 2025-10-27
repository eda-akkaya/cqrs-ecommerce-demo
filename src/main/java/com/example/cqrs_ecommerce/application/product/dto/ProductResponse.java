package com.example.cqrs_ecommerce.application.product.dto;

import java.math.BigDecimal;
import java.util.UUID;
// Geri Dönen Veri Nesnesi (DTO)
public record ProductResponse(
        UUID id, String name, String description,
        BigDecimal price, String currency, Integer stock
) {


}
