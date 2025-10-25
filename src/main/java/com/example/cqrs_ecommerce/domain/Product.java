package com.example.cqrs_ecommerce.domain;
import java.math.BigDecimal;
import java.util.UUID;

// Domain Object
//saf java

// Aggregate root
public class Product {
    private UUID id;
    private String name;
    private BigDecimal price;
    private String currency;
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

    private void setPrice(BigDecimal price){
        validatePrice(price);
        this.price = price;
    }

    private void validatePrice(BigDecimal price){

        if (price == null || price.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Price must be greater than or equal to zero.");
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
