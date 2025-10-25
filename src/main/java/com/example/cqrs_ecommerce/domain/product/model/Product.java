package com.example.cqrs_ecommerce.domain.product.model;
import java.util.Objects;


// Domain Object
//saf java

// Aggregate root
public class Product {
    // ProductId: reference tip
    private final ProductId id; //final old. için constructor gerekli
    private String name;
    private Money money;
    private String description;
    private Integer stock;

    // Kontrollü oluşturma için constructor private olmalı
    //Bu nesne sadece benim vereceğim factory metotlarıyla oluşturulsun.
    private Product(ProductId id, String name, Money money, String description, Integer stock) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.description = description;
        this.stock = stock;
// constructor içinde set çağırmak doğru bir yapı değil,
// validasyonları create ile yapacağım, buranın görevi sadece creation olacak
    }


// sistemdeki diğer nesneler, bunun üzerinden create etsin
    // create ederken id olmayacak her seferinde yeni id oluşacak sistem id göndersin istemiyorum
    // static factory method (idiom)
    public static  Product create(String name, Money money, String description, Integer stock){
        validateName(name);
        Objects.requireNonNull(money,"Money cannot be null.");
        validateDescription(description);
        validateStock(stock);


        return new Product(ProductId.generate(), name, money, description,stock);
    }

    // setter demek override etmek demek, veriyi değiştirmek
    // bizim domain nesnemizin veri ile işi yok.
    // setter yerine iş yapan metotlar olmalı. işlem sonucu değerleri değiştiren

    public void rename(String name){
        validateName(name);
        this. name = name ;
    }

    private static void validateName(String name){
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank.");
        if (name.length() < 2)
            throw new IllegalArgumentException("Name must be at least 2 characters");
    }

    public void changePrice(Money newPrice){
        Objects.requireNonNull(newPrice,"Price cannot be null");
        this.money = newPrice;
}

    public void setDescription(String description){
        validateDescription(description);
        this.description = description;

    }

    private static void validateDescription(String description){
        if (description == null || description.length() < 3)
            throw new IllegalArgumentException("Description must be at least 3 characters.");
        if (description.length() > 255)
            throw new IllegalArgumentException("Description length must be less than 255 characters.");
    }

    // stock override edilmez ya arttırılı ya da azaltılır
    public void dispatch(Integer quantityToDispatch){
        if (quantityToDispatch == null || quantityToDispatch <= 0)
            throw new IllegalArgumentException("Quantity to dispatch must be greater than 0");
        if (this.stock < quantityToDispatch)
            throw new IllegalArgumentException("Insufficient stock");

        validateStock(stock);
        this.stock -= stock;
    }

    public void restock(Integer quantityToRestock){
        if (quantityToRestock == null || quantityToRestock <=0 )
            throw new IllegalArgumentException("Quantity to restock must be positive.");

        this.stock += stock;

    }

    private static void validateStock(Integer stock){
        if (stock == null || stock <= 0)
            throw new IllegalArgumentException("Stock cannot be null or negative value.");
    }

    // getters
    public ProductId id() {
        return id;
    }

    public String name() {
        return name;
    }

    public Money money() {
        return money;
    }

    public String description() {
        return description;
    }

    public Integer stock() {
        return stock;
    }
}
