package com.example.cqrs_ecommerce.core.cqrs;


// Q tipi Komutu alıp işler. Genellikle geriye değer döndürmez (void)
// veya işlem sonucu için bir Result nesnesi döndürür.
public interface CommandHandler<Q extends Command<R>, R>{
    R handle(Q query);
}
