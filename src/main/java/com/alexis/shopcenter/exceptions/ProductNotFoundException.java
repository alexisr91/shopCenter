package com.alexis.shopcenter.exceptions;

public class ProductNotFoundException extends RuntimeException {
    
    public ProductNotFoundException(String message){

        super(message);
    }
}
