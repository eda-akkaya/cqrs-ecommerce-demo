package com.example.cqrs_ecommerce.persistence.product;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.UUID;
// Product domain nesnesinin db'ye geçirilirkenki hali

@Entity
@Table(name = "products")
public class JpaProductEntity {
    //bu bir db tablosu, ona uygun kodlayacağız
    // db'de Money, ProductId tipleri yok -> saf uuid kullanılacak, iki nesne arası entegrasyon kodla sağlanacak

    @Id
    @Column(columnDefinition = "uuid") //auto generate yok çünkü create edilirken generate ediliyor. generate etmeyi db'ye bırakmadık, belki ileride dosya sistemine geçilecek
    private UUID id;

    //validasyonlar varken neden tekrar yaptık? -> db ve domain ayrı yapılardır.
    // db'ye domain dışından da erişim olabilir örn; dbeaver. oradan erişimde de validassyon olmalı
    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    // precison: toplam kaç hane, scale:virgülden sonra kaç hane
    @Column(name = "amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal amount;
    @Column(name = "currency", nullable = false)
    private String currency;
    @Column(name = "stock", nullable = false)
    private Integer stock;

    public UUID id() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal amount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String currency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer stock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
