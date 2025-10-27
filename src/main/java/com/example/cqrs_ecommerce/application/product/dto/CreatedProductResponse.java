package com.example.cqrs_ecommerce.application.product.dto;

import java.util.UUID;

// Geri Dönen Veri Nesnesi (DTO)
public record CreatedProductResponse(UUID id, String name, String description) {
}
