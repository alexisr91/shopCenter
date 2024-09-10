package com.alexis.shopcenter.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import com.alexis.shopcenter.model.Category;


public interface CategoryRepository extends JpaRepository<Category,Long> {
    
    Category findByName(String name);
    Optional<Category> addProduct();
}
