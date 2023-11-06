package com.mruruc.application.services;

import com.mruruc.application.entity.Order;
import com.mruruc.application.exceptions.OrderNotConfirmedException;

import java.time.LocalDateTime;

public class OrderProcessor {
    private ShippingService shippingService;

    public OrderProcessor(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public LocalDateTime process(Order order){
        if(order.isConfirmed()){
           return shippingService.scheduleDelivery(order);
        }
        throw new OrderNotConfirmedException("Please Confirm The Order.");
    }


}
