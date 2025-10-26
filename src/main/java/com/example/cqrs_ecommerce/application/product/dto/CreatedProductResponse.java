package com.example.cqrs_ecommerce.application.product.dto;

import java.util.UUID;

public record CreatedProductResponse(UUID id, String name, String description) {
}
