package com.example.cqrs_ecommerce.persistence.product;

import com.example.cqrs_ecommerce.domain.product.model.Product;
import com.example.cqrs_ecommerce.domain.product.model.ProductId;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

//@Repository -> hangisini devreye sokmak istiyorsak onu aktif hale getiririz.
public class InMemoryProductRepositoryAdapter implements ProductRepository {

    private List<Product> products;

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return products.stream().findFirst();
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public List<Product> findAllPaged(int pageIndex, int pageSize) {
        return List.of();
    }

    @Override
    public void delete(ProductId productId) {

    }
}
