package com.mruruc.application.repository;

import com.mruruc.application.entity.Product;

import java.util.Optional;

public interface ProductRepo {
    void save(Product product);

    Optional<Product> findProductById(Long id);


}
