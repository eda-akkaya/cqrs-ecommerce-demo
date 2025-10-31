package com.example.cqrs_ecommerce.domain.product.repository;

import com.example.cqrs_ecommerce.domain.product.model.Product;
import com.example.cqrs_ecommerce.domain.product.model.ProductId;

import java.util.List;
import java.util.Optional;

// @Repository, extends JpaRepository gibi ifadeler burada yok. domain'deyiz : saf java
// bağımlılığın içeri doğru olması için, bağımlılık dışarı doğru talep edilmeli. bu dışarıya doğru taleplere port(interface) denir.
// domaine giriş yapmak istiyorsan bu kuralları uygulayacaksın. bana bunu bunu yapan methodları ver
// soyut (interface) 0> dışarıya kurallar dizisi vermek
public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(ProductId productId);
    List<Product> findAll();
    List<Product> findAllPaged(int pageIndex, int pageSize);
    void delete(ProductId productId);
    boolean existsByNameIgnoreCase(String name);
}
