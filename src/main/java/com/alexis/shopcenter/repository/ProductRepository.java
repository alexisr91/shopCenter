package com.alexis.shopcenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.alexis.shopcenter.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
