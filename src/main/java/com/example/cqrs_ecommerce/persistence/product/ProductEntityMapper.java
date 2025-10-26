package com.example.cqrs_ecommerce.persistence.product;

import com.example.cqrs_ecommerce.domain.product.model.Money;
import com.example.cqrs_ecommerce.domain.product.model.Product;
import com.example.cqrs_ecommerce.domain.product.model.ProductId;
import org.springframework.stereotype.Component;

//mapstruct ile daha zahmetli olacağı için bu şekilde yaptık
@Component
public class ProductEntityMapper {
    public JpaProductEntity toEntity(Product product){
        JpaProductEntity productEntity = new JpaProductEntity();
        productEntity.setId(product.id().value());
        productEntity.setName(product.name());
        productEntity.setDescription(product.description());
        productEntity.setStock(product.stock());
        productEntity.setAmount(product.money().amount());
        productEntity.setCurrency(product.money().currency());
        return productEntity;
    }

    public Product toDomain(JpaProductEntity entity){
    // product oluşturuken create()'i çağırıyorduk
        // Jpa'dan gelen veriyi Product'a yükleme işlemi old. için rehydrate
        return Product.rehydrate(
                new ProductId(entity.id()),
                entity.name(),
                new Money(entity.amount(), entity.currency()),
                entity.description(),
                entity.stock()
        );
    }
}
