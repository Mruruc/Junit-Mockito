package com.mruruc.application.exceptions;

public class OrderNotConfirmedException extends RuntimeException{
    public OrderNotConfirmedException(String message){
        super(message);
    }
}
