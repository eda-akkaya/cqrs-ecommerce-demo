package com.example.cqrs_ecommerce.domain;

import java.util.Optional;

// @Repository, extends JpaRepository gibi ifadeler burada yok. domain'deyiz : saf java
// bağımlılığın içeri doğru olması için, bağımlılık dışarı doğru talep edilmeli. bu dışarıya doğru taleplere port(interface) denir.
// domaine giriş yapmak istiyorsan bu kuralları uygulayacaksın. bana bunu bunu yapan methodları ver
public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(ProductId productId);
}
