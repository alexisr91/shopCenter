package com.alexis.shopcenter.request;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Optional;

import com.alexis.shopcenter.model.Category;




@Data
public class AddProductRequest {
    
    private Long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory;
    private String description;

    private Category category;

    public void setCategory(Optional<Category> category) {
    }

}
