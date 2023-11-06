package com.mruruc.testDoublesWithAndWithoutMockito.dummy;

import com.mruruc.application.entity.Order;
import com.mruruc.application.services.ShippingService;

import java.time.LocalDateTime;

public class DummyShippingTime implements ShippingService {
    @Override
    public LocalDateTime scheduleDelivery(Order order) {
        return LocalDateTime.of(2023,11,10,13,30);
    }
}
