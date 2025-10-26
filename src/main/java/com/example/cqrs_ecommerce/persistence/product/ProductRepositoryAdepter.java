package com.example.cqrs_ecommerce.persistence.product;

import com.example.cqrs_ecommerce.domain.product.model.Product;
import com.example.cqrs_ecommerce.domain.product.model.ProductId;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryAdepter implements ProductRepository {
    // domain'in istediklerini yerine getireceğim

    private final SpringDataProductRepository repository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepositoryAdepter(SpringDataProductRepository repository, ProductEntityMapper productEntityMapper) {
        this.repository = repository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Product save(Product product) {
        // Product -> JpaProductEntity mapping
        // DB'ye kaydet
        //kaydedilen yapıyı Product'a geri maple ve return et

        JpaProductEntity entity = productEntityMapper.toEntity(product);
        entity = this.repository.save(entity);

        return productEntityMapper.toDomain(entity);

    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return Optional.empty();
    }

    @Override
    public List<Product> findAll() {
        return List.of();
    }

    @Override
    public void delete(ProductId productId) {

    }
}
