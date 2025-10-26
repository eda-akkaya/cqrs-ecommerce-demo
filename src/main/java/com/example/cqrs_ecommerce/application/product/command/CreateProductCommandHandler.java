package com.example.cqrs_ecommerce.application.product.command;

import com.example.cqrs_ecommerce.application.product.dto.CreatedProductResponse;
import com.example.cqrs_ecommerce.application.product.dto.ProductResponse;
import com.example.cqrs_ecommerce.core.cqrs.CommandHandler;

import java.util.List;

public class CreateProductCommandHandler implements CommandHandler<CreateProductCommand, CreatedProductResponse>{
    // bu classın tek görevi lullanıcı bu komutu gönderdiğinde yapılacak işlemi göstermek
    // kullanıcıdan CreateProductCommand alıp geriye List<ProductResponse> dönecek


    @Override
    public CreatedProductResponse handle(CreateProductCommand query) {
        return null;
    }




}
