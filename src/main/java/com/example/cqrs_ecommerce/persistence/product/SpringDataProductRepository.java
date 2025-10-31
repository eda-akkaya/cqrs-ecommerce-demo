package com.example.cqrs_ecommerce.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// bir JpaRepository'sin, JpaProductEntity'sini kullanıyorsun, UUID ile işlem yapıyorsun.
public interface SpringDataProductRepository extends JpaRepository<JpaProductEntity, UUID> {

    boolean existsByNameIgnoreCase(String name);
}
