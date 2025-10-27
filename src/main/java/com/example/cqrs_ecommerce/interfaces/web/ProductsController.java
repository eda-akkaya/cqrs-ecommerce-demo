package com.example.cqrs_ecommerce.interfaces.web;

import com.example.cqrs_ecommerce.application.product.command.CreateProductCommand;
import com.example.cqrs_ecommerce.application.product.dto.CreatedProductResponse;
import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.application.product.query.ListProductsQuery;
import com.example.cqrs_ecommerce.application.product.query.ListProductsQueryHandler;
import com.example.cqrs_ecommerce.core.cqrs.CommandHandler;
import com.example.cqrs_ecommerce.core.cqrs.QueryHandler;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//application katmanını kullanarak presentation katmanına enjeksiyon yapılır.

@RestController
@RequestMapping("/api/v1/products")
@Validated
public class ProductsController {
    // QueryHandler, ListProductsQuery'i geriye List<ProductResponse> döndürecek şekilde handle etsin
    private final QueryHandler<ListProductsQuery, List<ProductResponse>> listProductsQueryHandler;
    private final CommandHandler<CreateProductCommand, CreatedProductResponse> createProductCommandHandler;

    public ProductsController(QueryHandler<ListProductsQuery, List<ProductResponse>> listProductsQueryHandler, CommandHandler<CreateProductCommand, CreatedProductResponse> createProductCommandHandler) {
        this.listProductsQueryHandler = listProductsQueryHandler;
        this.createProductCommandHandler = createProductCommandHandler;
    }

    @GetMapping
    public List<ProductResponse> getProducts(@Valid ListProductsQuery query){
        return listProductsQueryHandler.handle(query);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedProductResponse createProduct(@Valid @RequestBody CreateProductCommand command){
        return createProductCommandHandler.handle(command);
    }
}
