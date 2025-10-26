package com.example.cqrs_ecommerce.application.product.query;

import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.core.cqrs.Query;

import java.util.List;

public record ListProductsQuery(Integer pageIndex,
                                Integer pageSize) implements Query<List<ProductResponse>>  {
}
// bir query olduğu belli ve bu query'nin  handle işlemi sonucu geriye bir ProductResponse döneceği belli