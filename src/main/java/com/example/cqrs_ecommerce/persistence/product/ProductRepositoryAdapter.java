package com.example.cqrs_ecommerce.persistence.product;

import com.example.cqrs_ecommerce.domain.product.model.Product;
import com.example.cqrs_ecommerce.domain.product.model.ProductId;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepositoryAdapter implements ProductRepository {
    // domain'in istediklerini yerine getirecek

    private final SpringDataProductRepository repository;
    private final ProductEntityMapper productEntityMapper;

    public ProductRepositoryAdapter(SpringDataProductRepository repository, ProductEntityMapper productEntityMapper) {
        this.repository = repository;
        this.productEntityMapper = productEntityMapper;
    }

    @Override
    public Product save(Product product) {
        // Product -> JpaProductEntity mapping
        // DB'ye kaydet
        //kaydedilen yapıyı Product'a geri maple ve return et

        JpaProductEntity entity = productEntityMapper.toEntity(product);
        entity = repository.save(entity);

        return productEntityMapper.toDomain(entity);

    }

    @Override
    public Optional<Product> findById(ProductId productId) {
        return repository
                .findById(productId.value())
                .map(productEntityMapper::toDomain); //.map(p->productEntityMapper.toDomain(p));
    }

    @Override
    public List<Product> findAll() {
        return repository
                .findAll()
                .stream()
                //method reference ::
                .map(productEntityMapper::toDomain)
                .toList();

    }

    @Override
    public List<Product> findAllPaged(int pageIndex, int pageSize) {
        return repository.findAll(PageRequest.of(pageIndex,pageSize))
                .stream()
                .map(productEntityMapper::toDomain)
                .toList();
    }

    @Override
    public void delete(ProductId productId) {
        repository.deleteById(productId.value());
    }

    @Override
    public boolean existsByNameIgnoreCase(String name) {
        return repository.existsByNameIgnoreCase(name);

    }


}
