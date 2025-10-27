package com.example.cqrs_ecommerce.application.product.mapper;

import com.example.cqrs_ecommerce.application.product.command.CreateProductCommand;
import com.example.cqrs_ecommerce.domain.product.model.Money;
import com.example.cqrs_ecommerce.domain.product.model.Product;

public class CreateProductMapper {
    public Product toDomain(CreateProductCommand command){
        return Product.create(command.name(),
                new Money(command.price(), command.currency()),
                command.description(),
                command.stock());
    }
}
