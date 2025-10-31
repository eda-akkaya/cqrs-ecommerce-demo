package com.example.cqrs_ecommerce.domain.product.policy;

public interface ProductNameUniquePolicy {
    boolean isUnique(String name);
}
