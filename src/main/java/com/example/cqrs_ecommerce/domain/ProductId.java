package com.example.cqrs_ecommerce.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

// Dışarıdan gelen UUID'yi sarmallayan reference tip. Primitive obsession engellenir.
public record ProductId(UUID value) implements Serializable {
    public ProductId{
        // bu hata mesajları kullanıcıya gitmeyecek,
        // bu domaini kullanarak adapter ile kodlama yapacak developer'ı ilgilendirir
        Objects.requireNonNull(value,"Value for ProductId cannot be null");
    }

    // Factory method
    public static ProductId generate(){
        return new ProductId(UUID.randomUUID());
    }
}
