package com.alexis.shopcenter.service.product;

import com.alexis.shopcenter.model.Product;

public interface ProductRepository{

    Product findById(Long id);

}
