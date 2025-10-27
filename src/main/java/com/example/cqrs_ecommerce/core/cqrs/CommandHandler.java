package com.example.cqrs_ecommerce.core.cqrs;


// C tipi Komutu alıp işler. Genellikle geriye değer döndürmez (void)
// veya işlem sonucu için bir Result nesnesi döndürür.
public interface CommandHandler<C extends Command<R>, R>{
    R handle(C query);
}
