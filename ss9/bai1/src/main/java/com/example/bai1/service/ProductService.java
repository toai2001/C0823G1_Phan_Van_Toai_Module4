package com.example.bai1.service;

import com.example.bai1.model.Product;
import com.example.bai1.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ProductService implements IProductService {
    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public Iterable<Product> findall() {
        return iProductRepo.findAll();
    }

    @Override
    public void saveProduct(Product product) {
        iProductRepo.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return iProductRepo.findById(id);
    }
}
