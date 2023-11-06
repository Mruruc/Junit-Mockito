package com.mruruc.testDoublesWithAndWithoutMockito.spy;

import com.mruruc.application.entity.Product;
import com.mruruc.application.repository.ProductRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SpyProductImp implements ProductRepo {

    List<Product> list=new ArrayList<>();
    @Override
    public void save(Product product) {
        list.addFirst(product);
    }

    @Override
    public Optional<Product> findProductById(Long id) {
        return null;
    }

    int numberOfProduct(){
        return list.size();
    }

    Optional<Product> firstProduct(){
        return list.stream().findFirst();
    }




}
