package com.example.cqrs_ecommerce.domain;
import java.math.BigDecimal;
import java.util.UUID;

// Domain Object
//saf java

// Aggregate root
public class Product {
    // ProductId: reference tip
    private ProductId id;
    private String name;
    private Money money;
    private String description;

    private void setName(String name){
        validateName(name);
        this. name = name ;
    }

    private void validateName(String name){
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("Name cannot be null or blank.");
        if (name.length() < 2)
            throw new IllegalArgumentException("Name must be at least 2 characters");
    }

    public void setMoney(Money money){
        //  kendi içindeki kurallarla validasyon kontrolü yaptığı için burada çok kural yok
        if (money == null)
            throw new IllegalArgumentException("Money cannot be null.");

        this.money = money;
    }

    public void setDescription(String description){
        validateDescription(description);
        this.description = description;

    }

    private void validateDescription(String description){
        if (description == null || description.length() < 3)
            throw new IllegalArgumentException("Description must be at least 3 characters.");
        if (description.length() > 255)
            throw new IllegalArgumentException("Description length must be less than 255 characters.");
    }

}
