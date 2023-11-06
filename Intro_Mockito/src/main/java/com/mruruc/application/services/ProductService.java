package com.mruruc.application.services;

import com.mruruc.application.entity.Product;
import com.mruruc.application.exceptions.ProductNotFoundExceptions;
import com.mruruc.application.repository.ProductRepo;

import java.util.Optional;

public class ProductService {
    ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public void addProduct(Product product){
        repo.save(product);
    }

    public void updatePrice(Long id,Double newPrice){

        if(id != null){
            Optional<Product> product= repo.findProductById(id);
            // checkin that price should not be null
            if( newPrice != null){
                product.ifPresentOrElse((p)->{
                    p.setPrice(newPrice);
                    repo.save(p);
                }, ()->{
                    throw new ProductNotFoundExceptions("Product Not Found !");
                });
                return;
//            if(product.isPresent()){
//                Product product1 = product.get();
//                product1.setPrice(newPrice);
//                repo.save(product1);
//            }
            }
            throw new NullPointerException("Price Is Null!");
        }

        throw new NullPointerException("Id is Null!");

      //  product.ifPresent(value -> value.setPrice(newPrice));



    //    Product product1 =
        //    product.orElseThrow(() -> new ProductNotFoundExceptions("Not Found!"));
     //   product1.setPrice(newPrice);


//        if (product.isPresent()) {
//             product.get().setPrice(newPrice);
//             return;
//        }
//        throw new ProductNotFoundExceptions("Specified Id Does Not Exists!");
    }

    public Product findProduct(Long id){
        Optional<Product> productById = repo.findProductById(id);
        Product product =
                productById.isPresent() ?
                        productById.get() : productById.orElseThrow(()-> {
            throw new ProductNotFoundExceptions("NoT FounD!");
        });
        return product;
    }
}
