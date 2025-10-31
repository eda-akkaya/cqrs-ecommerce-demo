package com.example.cqrs_ecommerce.application.product.command;

import com.example.cqrs_ecommerce.application.product.dto.CreatedProductResponse;
import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.application.product.mapper.CreateProductMapper;
import com.example.cqrs_ecommerce.core.cqrs.CommandHandler;
import com.example.cqrs_ecommerce.domain.product.model.Product;
import com.example.cqrs_ecommerce.domain.product.policy.ProductNameUniquePolicy;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateProductCommandHandler implements CommandHandler<CreateProductCommand, CreatedProductResponse>{

    private final CreateProductMapper createProductMapper;
    private final ProductRepository productRepository;
    private final ProductNameUniquePolicy productNameUniquePolicy;

    public CreateProductCommandHandler(CreateProductMapper createProductMapper, ProductRepository productRepository, ProductNameUniquePolicy productNameUniquePolicy) {
        this.createProductMapper = createProductMapper;
        this.productRepository = productRepository;
        this.productNameUniquePolicy = productNameUniquePolicy;
    }

    @Override
    public CreatedProductResponse handle(CreateProductCommand command) {
        // business rules
        if (!productNameUniquePolicy.isUnique(command.name())){
            throw new RuntimeException("product name is not unique");
        }

        Product product = createProductMapper.toDomain(command);
        product = productRepository.save(product);
        return createProductMapper.toResponse(product);
    }




}
