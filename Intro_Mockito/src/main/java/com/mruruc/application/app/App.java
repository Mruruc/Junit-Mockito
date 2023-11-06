package com.mruruc.application.app;


import com.mruruc.application.entity.Order;
import com.mruruc.application.entity.Product;
import com.mruruc.application.exceptions.OrderNotConfirmedException;
import com.mruruc.application.exceptions.ProductNotFoundExceptions;
import com.mruruc.application.services.OrderProcessor;
import com.mruruc.application.services.ShippingTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class App {
    public static void main(String[] args) {

//        Product product1 = new Product(1L, "FOOD", 20.0);
//        Product product2 = new Product(2L, "Potato", 9.0);
//        Order order = new Order(1L, LocalDate.now(),
//                "waflo21@gmail.com",
//                List.of(product1, product2), false);


//        try {
//            OrderProcessor processor = new OrderProcessor(new ShippingTime());
//
//            processor.process(order)
//                    .isEqual(LocalDateTime.of(2023, 11, 10, 13, 30));
//            System.out.println("Order Confirmed!");
//            System.out.println("Order:\n" + product1 + "\n" + product2);
//
//        } catch (OrderNotConfirmedException ex) {
//            System.out.println("Order Not Confirmed!");
//            System.out.println("Reason: "+ex.getMessage());
//        }


        /*
        Optional<Product> testProduct = test(10L);
      //  Product product = testProduct.orElse(new Product(3L, "Chocolate", 7.0));
       // Product product = testProduct.orElseThrow(() -> new ProductNotFoundExceptions("Not Found"));
       // Product product = testProduct.isPresent() ?testProduct.get() : testProduct.orElseThrow(()-> new ProductNotFoundExceptions("Not Found!"));

        testProduct
                .ifPresentOrElse((product) -> {
                    product.setPrice(201.0);
                    System.out.println(product);
                }, () -> {
                    throw new ProductNotFoundExceptions("Not Found!");
                });

       // System.out.println(product);

    }

    public static Optional<Product> test(Long id){
        Product product1 = new Product(1L, "FOOD", 20.0);
        if(id != null && id == 1L){
            return Optional.of(product1);
        }
      //  throw new ProductNotFoundExceptions("Not Found!");
        return Optional.empty();
    }

    */


    }
}
