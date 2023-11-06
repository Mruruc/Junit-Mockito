package com.mruruc.mockito_Annotations;

import com.mruruc.application.entity.Product;
import com.mruruc.application.exceptions.ProductNotFoundExceptions;
import com.mruruc.application.repository.ProductRepo;
import com.mruruc.application.services.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StubbingTest {
    private Product product;
    @Mock
    private ProductRepo mockRepo;
    @InjectMocks
    private ProductService service;
    private Product product1;
    private Product product2;

    @BeforeEach
    void init() {
        this.product = new Product(1L, "Water", 3.0);
        this.product1 = new Product(1L, "Water", 3.0);
        this.product2 = new Product(1L, "Water", 3.0);
    }


    @Test
    @DisplayName("Testing Void Method With Verify")
    void verify_test() {
        //  var productRepo = Mockito.mock(ProductRepo.class);

        // this.service=new ProductService(productRepo);


        service.addProduct(product);
        service.addProduct(product1);
        service.addProduct(product2);
       // verify(mockRepo,times(3)).save(product);
        verify(mockRepo,atLeast(1)).save(product);
        verify(mockRepo).save(product);

    }

    @Test
    @DisplayName("Testing Void Method With doNothing")
    void doNothing_test() {
        doNothing().when(mockRepo).save(product);
        service.addProduct(product);
    }

    @Test
    @DisplayName("Testing UpdatePrice Method")
    void updatePriceTest() {
        when(mockRepo.findProductById(1L))
                .thenReturn(Optional.of(new Product(1L, "Plastic Bag", 0.25)));
        service.updatePrice(1L, 0.28);
        verify(mockRepo).findProductById(1L);
    }

    @Test
    @DisplayName("Testing UpdatePrice Method")
    void updatePriceTest2() {
//        when(mockRepo.findProductById(1L))
//                .thenReturn(Optional.of(new Product(1L, "Plastic Bag", 0.25)));

        //verifyNoInteractions(mockRepo);
        assertThrows(NullPointerException.class, () -> service.updatePrice(null, 0.28));
    }


    @Test
    @DisplayName("Testing UpdatePrice Method")
    void updatePriceTest3() {

        when(mockRepo.findProductById(1L))
                .thenReturn(Optional.of(product));

        service.updatePrice(1L, 0.28);
        // service.addProduct(product);
        InOrder inOrder = Mockito.inOrder(mockRepo);
        inOrder.verify(mockRepo).findProductById(1L);
        inOrder.verify(mockRepo).save(product);
    }


    @Test
    @DisplayName("Testing Exceptions")
    void testing_exceptions() {
       when(mockRepo.findProductById(1L))
                .thenThrow(ProductNotFoundExceptions.class);

        assertThrows(ProductNotFoundExceptions.class, () -> service.findProduct(1L));

    }

    @AfterEach
    void destroy() {
        this.service=null;
        this.product=null;
        this.product2=null;
        this.product1=null;
    }


}
