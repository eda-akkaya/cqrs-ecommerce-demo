package com.example.cqrs_ecommerce;

import com.example.cqrs_ecommerce.domain.product.model.Money;
import com.example.cqrs_ecommerce.domain.product.model.Product;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        //  bu şekilde oluşturulamıyor artık, private access
        // Product product = new Product();

        Product product = Product.create(
                "ürün 1",
                new Money(BigDecimal.valueOf(350),"TRY"),
                "Ürün 1 açıklaması",
                140
        );
        product.setName("ürün 2");
        System.out.println(product.name());
    }
}

