package com.example.cqrs_ecommerce.core.cqrs;

public interface QueryHandler<Q extends Query<R>,R>  {
    // sen bir query alacaksın, bir de response türü alacaksın
    // Q, geriye R dönen bir query

    R handle(Q query);
}
