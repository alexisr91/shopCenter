package com.alexis.shopcenter.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alexis.shopcenter.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

    Optional<Product> findById(Long id);

    Optional<Product> deleteProductById(Product product);

    void delete(Product product);

    List<Product> findAll();

    List<Product> findByCategoryName(String category);

    List<Product> findByBrand(String brand);

    List<Product> findByCategoryAndBrand(String category, String brand);

    List<Product> findByName(String name);

    List<Product> findByBrandAndName(String brand, String name);

    Long countProductsByBrandAndName(String brand, String name);

}