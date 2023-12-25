package com.example.bai1.service;

import com.example.bai1.model.Product;
import com.example.bai1.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public List<Product> showAllProduct() {
        return iProductRepo.showAllProduct();
    }

    @Override
    public void addProduct(Product product) {
        iProductRepo.addProduct(product);

    }

    @Override
    public void updateProduct(Product product) {
        iProductRepo.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        iProductRepo.deleteProduct(id);
    }

    @Override
    public Product getProduct(Integer id) {
        return iProductRepo.getProduct(id);
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        return iProductRepo.searchProduct(nameProduct);
    }
}
