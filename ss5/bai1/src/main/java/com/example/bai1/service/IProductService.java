package com.example.bai1.service;

import com.example.bai1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showAllProduct();
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Integer id);
    Product getProduct(Integer id);
    List<Product> searchProduct(String nameProduct);
}
