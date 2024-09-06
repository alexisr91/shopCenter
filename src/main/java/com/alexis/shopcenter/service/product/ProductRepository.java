package com.alexis.shopcenter.service.product;

import java.util.Optional;

import com.alexis.shopcenter.model.Product;

public interface ProductRepository{

    Optional<Product> findById(Long id);
    Optional<Product> deleteProductById(Product product);
    Optional<Product> delete(Product product);

}
