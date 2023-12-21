package com.example.baitap1.service;

import com.example.baitap1.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> showProduct();

    void addProduct(Product product);

    void updateProduct(int id, Product product);

    void deleteProduct(int id);

    Product getProduct(int id);

    List<Product> searchProduct(String nameProduct);
}
