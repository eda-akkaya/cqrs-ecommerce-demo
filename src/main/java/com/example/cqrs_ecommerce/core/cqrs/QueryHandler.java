package com.example.cqrs_ecommerce.core.cqrs;
// Query Handler Arayüzü: Q (Query <R>) alıp R (Result/DTO) döndürür.

/*
Tip Parametresi	Anlamı	Kısıtlama (extends)
Q: Sorgu Tipi (Query Type)
Q extends Query<R>: Q tipinin bir Query olması ve bu Query'nin, R tipinde bir sonuç döndüreceğini ilan etmesi gerekir.
R: Sonuç Tipi (Result Type): Herhangi bir tip olabilir. Bu, sorgunun döndüreceği DTO (Data Transfer Object) tipini temsil eder.
*/

public interface QueryHandler<Q extends Query<R>,R>  {
    // sen bir query alacaksın, bir de response türü alacaksın
    // Q, geriye R dönen bir query

    R handle(Q query);
}
