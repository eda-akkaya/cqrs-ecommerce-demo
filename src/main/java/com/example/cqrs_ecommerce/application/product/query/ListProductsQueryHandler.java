package com.example.cqrs_ecommerce.application.product.query;

import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.application.product.mapper.ProductResponseMapper;
import com.example.cqrs_ecommerce.core.cqrs.QueryHandler;
import com.example.cqrs_ecommerce.domain.product.repository.ProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ListProductsQueryHandler implements QueryHandler<ListProductsQuery, List<ProductResponse>> {

    private final ProductRepository productRepository;
    private final ProductResponseMapper productResponseMapper;

    public ListProductsQueryHandler(ProductRepository productRepository, ProductResponseMapper productResponseMapper) {
        this.productRepository = productRepository;
        this.productResponseMapper = productResponseMapper;
    }

    @Override
    public List<ProductResponse> handle(ListProductsQuery query) {
        return productRepository
                .findAllPaged(query.pageIndex(), query.pageSize())
                .stream()
                .map(productResponseMapper::toResponse)
                .toList();
    }
}
