package com.example.cqrs_ecommerce.application.product.command;

import com.example.cqrs_ecommerce.application.product.dto.CreatedProductResponse;
import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.core.cqrs.CommandHandler;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;

import java.util.List;

public class CreateProductCommandHandler implements CommandHandler<CreateProductCommand, CreatedProductResponse>{


    private final ProductRepository productRepository;

    public CreateProductCommandHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public CreatedProductResponse handle(CreateProductCommand query) {
        return null;
    }




}
