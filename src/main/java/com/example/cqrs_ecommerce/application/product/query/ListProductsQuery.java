package com.example.cqrs_ecommerce.application.product.query;

import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.core.cqrs.Query;
import jakarta.validation.constraints.Min;

import java.util.List;

public record ListProductsQuery(@Min(0) Integer pageIndex,
                                @Min(1) Integer pageSize) implements Query<List<ProductResponse>>  {
}
// bir query olduğu belli ve bu query'nin  handle işlemi sonucu geriye bir ProductResponse listesi döneceği belli