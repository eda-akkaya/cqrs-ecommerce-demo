package com.example.cqrs_ecommerce.domain.product.model;

import java.math.BigDecimal;
import java.util.Objects;

// Class'ın değiştirilemez (immutable) hali
//Value Object: Değer Nesnesi
public record Money(BigDecimal amount, String currency) {
    public Money {
        Objects.requireNonNull(amount);
        Objects.requireNonNull(currency);
        // Objects'te istediğin kural yoksa saf java ile de yazabilirsin
        if (amount.signum() < 0)
            throw new IllegalArgumentException("Amount must be positive");
        if (currency.isBlank())
            throw new IllegalArgumentException("Currency cannot be blank.");
    }
}
