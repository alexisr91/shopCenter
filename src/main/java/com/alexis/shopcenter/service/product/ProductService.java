package com.alexis.shopcenter.service.product;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.alexis.shopcenter.exceptions.ProductNotFoundException;
import com.alexis.shopcenter.model.Category;
import com.alexis.shopcenter.model.Product;
import com.alexis.shopcenter.repository.CategoryRepository;
import com.alexis.shopcenter.repository.ProductRepository;
import com.alexis.shopcenter.request.AddProductRequest;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor // Pour injecter une dépendance, il faut que la variable soit de type final
public class ProductService implements IProductService{
    
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public Product addProduct(AddProductRequest request){
        
        // Check if the category is found in the DB
        // If Yes, set it as a new product category
        // If No, then save it as a new category
        // The set as the new product category
        
        Optional<Category> category = Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()));
                .orElseGet(()-> {
                    Category newCategory = new Category(request.getCategory().getName());
                    return categoryRepository.save(newCategory);
                });
        request.setCategory(category);   
        return productRepository.save(createProduct(request, category));
    }


    private Product createProduct(AddProductRequest request, Optional<Category> category){
        return new Product(
                request.getName(),
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category
        );
    }

    @Override
    public Product getProductById(Long id) {
      
        return productRepository.findById(id)
        .orElseThrow(()->new ProductNotFoundException("Product not found"));
    }

    @Override
    public void deleteProductById(Long id) {
        
        productRepository.findById(id).ifPresentOrElse(product->productRepository.deleteProductById(product), 
        ()->{throw new ProductNotFoundException("Product Not found !");});
    }

    @Override
    public void updateProduct(Product product, Long productId) {
        
    }

    @Override
    public List<Product> getAllProducts() {
        
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
       
        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        
        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        
        return productRepository.findByCategoryAndBrand(category,brand);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByBrandAndName(String brand, String name) {
       
        return productRepository.findByBrandAndName(brand, name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        
        return productRepository.countProductsByBrandAndName(brand,name);
    }
}
