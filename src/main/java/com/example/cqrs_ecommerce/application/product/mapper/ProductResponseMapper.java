package com.example.cqrs_ecommerce.application.product.mapper;

import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.domain.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResponseMapper {
    public ProductResponse toResponse(Product product){
        return new ProductResponse(
                product.id().value(),
                product.name(),
                product.description(),
                product.money().amount(),
                product.money().currency(),
                product.stock()
        );
    }
}
