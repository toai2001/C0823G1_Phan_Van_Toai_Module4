package com.example.bai1.service;

import com.example.bai1.model.Product;

import java.util.Optional;

public interface IProductService {
    Iterable<Product>findall();
    void saveProduct(Product product);
    Optional<Product> findById(Long id);

}
