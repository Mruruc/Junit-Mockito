package com.mruruc.application.exceptions;

public class ProductNotFoundExceptions extends RuntimeException{
    public ProductNotFoundExceptions(String message){
        super(message);
    }
}
