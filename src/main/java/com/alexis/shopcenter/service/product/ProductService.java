package com.alexis.shopcenter.service.product;

import java.util.List;
import org.springframework.stereotype.Service;

import com.alexis.shopcenter.exceptions.ProductNotFoundException;
import com.alexis.shopcenter.model.Product;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ProductService implements IProductService{
    
    private ProductRepository productRepository;

    @Override
    public Product addProduct(Product product){
        return null;
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
        
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategory(Long category) {
       
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrand(String brand) {
        
        return List.of();
    }

    @Override
    public List<Product> getProductsByCategoryAndBrand(String category, String brand) {
        
        return List.of();
    }

    @Override
    public List<Product> getProductsByName(String name) {
        
        return List.of();
    }

    @Override
    public List<Product> getProductsByBrandAndName(String category, String name) {
       
        return List.of();
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'countProductsByBrandAndName'");
    }

    
}
