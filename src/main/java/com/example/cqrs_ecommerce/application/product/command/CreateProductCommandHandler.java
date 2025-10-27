package com.example.cqrs_ecommerce.application.product.command;

import com.example.cqrs_ecommerce.application.product.dto.CreatedProductResponse;
import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.application.product.mapper.CreateProductMapper;
import com.example.cqrs_ecommerce.core.cqrs.CommandHandler;
import com.example.cqrs_ecommerce.domain.product.model.Product;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateProductCommandHandler implements CommandHandler<CreateProductCommand, CreatedProductResponse>{

    private final CreateProductMapper createProductMapper;
    private final ProductRepository productRepository;

    public CreateProductCommandHandler(CreateProductMapper createProductMapper, ProductRepository productRepository) {
        this.createProductMapper = createProductMapper;
        this.productRepository = productRepository;
    }

    @Override
    public CreatedProductResponse handle(CreateProductCommand command) {
        // TODO: business rules
        Product product = createProductMapper.toDomain(command);
        product = productRepository.save(product);
        return createProductMapper.toResponse(product);
    }




}
