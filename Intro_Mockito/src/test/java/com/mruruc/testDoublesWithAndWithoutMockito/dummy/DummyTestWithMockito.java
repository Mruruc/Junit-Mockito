package com.mruruc.testDoublesWithAndWithoutMockito.dummy;

import com.mruruc.application.entity.Order;
import com.mruruc.application.entity.Product;
import com.mruruc.application.exceptions.OrderNotConfirmedException;
import com.mruruc.application.services.OrderProcessor;
import com.mruruc.application.services.ShippingService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DummyTestWithMockito {
    private Product product1;
    private Product product2;
    private Order order;
    private OrderProcessor processor;

    @BeforeEach
    void init(){
        this.product1 = new Product(1L, "FOOD", 20.0);
        this.product2 = new Product(2L, "Potato", 9.0);
        this.order=new Order(1L, LocalDate.now(),
                                 "waflo@gmail.com",
                                 List.of(product1,product2),
                                  true);
    }

    @Test
    void testDummy_Mockito(){
        ShippingService mock = mock(ShippingService.class);
        OrderProcessor mock_processor=new OrderProcessor(mock);

        when(mock.scheduleDelivery(order))
                .thenReturn(LocalDateTime.of(2023, 11, 10, 13, 30));

        LocalDateTime actual = mock_processor.process(order);

        assertEquals(LocalDateTime.
                          of(2023, 11, 10, 13, 30)
                         ,actual);


    }


    @Test
    void testDummy_Mockito_Case2(){
        ShippingService mock = mock(ShippingService.class);
        OrderProcessor mock_processor=new OrderProcessor(mock);
        order.setConfirmed(false);
        when(mock.scheduleDelivery(order))
                .thenReturn(LocalDateTime.of(2023, 11, 10, 13, 30));

        assertThrows(OrderNotConfirmedException.class,
                          ()-> mock_processor.process(order));

    }

    @AfterEach
    void destroy() {
        this.product1 = null;
        this.product2 = null;
        this.order = null;

    }

}
