package com.mruruc.testDoublesWithAndWithoutMockito.dummy;

import com.mruruc.application.entity.Order;
import com.mruruc.application.entity.Product;
import com.mruruc.application.exceptions.OrderNotConfirmedException;
import com.mruruc.application.services.OrderProcessor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class DummyTest {
    private Product product1;
    private Product product2;
    private Order order;
    private OrderProcessor processor;
    private DummyShippingTime dummyShippingTime;

    @BeforeEach
    void init() {
        this.product1 = new Product(1L, "FOOD", 20.0);
        this.product2 = new Product(2L, "Potato", 9.0);
        this.order =
                new Order(1L,
                        LocalDate.now(),
                        "waflo21@gmail.com",
                        List.of(product1, product2),
                       true);

        this.dummyShippingTime=new DummyShippingTime();

        this.processor= new OrderProcessor(dummyShippingTime);
    }

    @Test
    @DisplayName("Ensuring Not Using Instance of Real ShippingService")
    void ensureTest() {
        assertInstanceOf(DummyShippingTime.class,dummyShippingTime);
    }

    @Test
    @DisplayName("Testing OrderProcess with Confirmed Order")
    void testDummy() {
        var result = processor.process(order);
        assertEquals(LocalDateTime.of(2023, 11, 10, 13, 30),
                result);
    }
    @Test
    @DisplayName("Testing OrderProcess with Not Confirmed Order!")
    void testDummy2() {
        order.setConfirmed(false);
        assertThrows(OrderNotConfirmedException.class,()-> processor.process(order));
    }

    @AfterEach
    void destroy() {
        this.product1 = null;
        this.product2 = null;
        this.order = null;
        this.processor=null;

    }
}
