package com.example.bai1.repo;

import com.example.bai1.model.Product;

import java.util.List;

public interface IProductRepo {
    List<Product> showAllProduct();

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer id);

    Product getProduct(Integer id);

    List<Product> searchProduct(String nameProduct);
}
