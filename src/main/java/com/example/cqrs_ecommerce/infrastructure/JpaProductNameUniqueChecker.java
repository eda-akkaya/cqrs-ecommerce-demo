package com.example.cqrs_ecommerce.infrastructure;

import com.example.cqrs_ecommerce.domain.product.policy.ProductNameUniquePolicy;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

@Component
public class JpaProductNameUniqueChecker implements ProductNameUniquePolicy {

    private final ProductRepository productRepository;

    public JpaProductNameUniqueChecker(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public boolean isUnique(String name) {
        return !productRepository.existsByNameIgnoreCase(name);
    }
}
