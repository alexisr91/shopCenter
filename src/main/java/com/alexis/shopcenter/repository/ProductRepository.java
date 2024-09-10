package com.alexis.shopcenter.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.alexis.shopcenter.model.Category;
import com.alexis.shopcenter.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    void delete(Product product);  // Ceci est suffisant pour la suppression d'un produit
    List<Product> findAll();
    List<Product> findByCategoryName(String category);
    List<Product> findByBrand(String brand);
    List<Product> findByCategoryAndBrand(String category, String brand);
    Optional<Category> findByName(String name);
    List<Product> findByBrandAndName(String brand, String name);
    Long countProductsByBrandAndName(String brand, String name);
}
