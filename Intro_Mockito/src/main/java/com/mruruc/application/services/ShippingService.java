package com.mruruc.application.services;

import com.mruruc.application.entity.Order;

import java.time.LocalDateTime;

public interface ShippingService {
    LocalDateTime scheduleDelivery(Order order);
}
