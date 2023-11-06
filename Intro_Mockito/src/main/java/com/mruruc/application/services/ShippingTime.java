package com.mruruc.application.services;

import com.mruruc.application.entity.Order;

import java.time.LocalDateTime;

public class ShippingTime implements ShippingService{
    public ShippingTime() {
    }

    @Override
    public LocalDateTime scheduleDelivery(Order order) {
        return LocalDateTime.of(2023,11,10,13,30);
    }
}
