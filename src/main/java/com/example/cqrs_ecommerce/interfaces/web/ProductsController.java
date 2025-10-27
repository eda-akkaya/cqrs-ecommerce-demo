package com.example.cqrs_ecommerce.interfaces.web;

import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.application.product.query.ListProductsQuery;
import com.example.cqrs_ecommerce.application.product.query.ListProductsQueryHandler;
import com.example.cqrs_ecommerce.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//application katmanını kullanarak presentation katmanına enjeksiyon yapılır.

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductsController {
    // QueryHandler, ListProductsQuery'i geriye List<ProductResponse> döndürecek şekilde handle etsin
    private final QueryHandler<ListProductsQuery, List<ProductResponse>> listProductsQueryHandler;

    public ProductsController(QueryHandler<ListProductsQuery, List<ProductResponse>> listProductsQueryHandler) {
        this.listProductsQueryHandler = listProductsQueryHandler;
    }

    @GetMapping
    public List<ProductResponse> getProducts(@Valid ListProductsQuery query){
        return listProductsQueryHandler.handle(
                query
        );
    }
}
