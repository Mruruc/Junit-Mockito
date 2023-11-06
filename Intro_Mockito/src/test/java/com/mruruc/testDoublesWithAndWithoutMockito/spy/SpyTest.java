package com.mruruc.testDoublesWithAndWithoutMockito.spy;

import com.mruruc.application.entity.Product;
import com.mruruc.application.repository.ProductRepo;
import com.mruruc.application.services.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SpyTest {
    private ProductService service;
    private SpyProductImp spyProductImp;

    private Product product;
    private Product product2;

    @BeforeEach
    void init(){
        this.product= new Product(1L, "FOOD", 20.0);
        this.product2= new Product(1L, "FOOD", 20.0);
        this.spyProductImp=new SpyProductImp();
        this.service=new ProductService(spyProductImp);
    }

    @Test
    void testSpy(){
        service.addProduct(product);
        service.addProduct(product2);
        assertEquals(2,spyProductImp.numberOfProduct());
        assertEquals(spyProductImp.firstProduct(), Optional.of( product2));
    }


    @Test
    void spy_test_Mockito(){
        ProductRepo mockRepo = mock(ProductRepo.class);
        this.service=new ProductService(mockRepo);
        service.addProduct(product);
        service.addProduct(product2);

        verify(mockRepo).save(product);
        verify(mockRepo).save(product2);

    }


    @AfterEach
    void tearDown(){
        this.product=null;
        this.product2=null;
        this.service=null;
        this.spyProductImp=null;
    }
}
