package com.example.cqrs_ecommerce.core.cqrs;

public interface CommandHandler<Q extends Command<R>, R>{
    R handle(Q query);
}
