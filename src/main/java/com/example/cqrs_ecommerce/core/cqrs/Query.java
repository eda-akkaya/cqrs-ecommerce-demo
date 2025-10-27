package com.example.cqrs_ecommerce.core.cqrs;

// Marker Interface: Bu sınıfın bir Sorgu olduğunu belirtir.
// QUERY Arayüzü: Hangi Result (R) tipini döndüreceğini ilan eder.
// İçerik boş kalır, sadece marker (işaretleyici) ve result tipini belirtir.
public interface Query<R>{
    // queryler de geriye bir response döner
}
