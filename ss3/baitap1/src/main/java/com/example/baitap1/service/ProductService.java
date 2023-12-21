package com.example.baitap1.service;

import com.example.baitap1.model.Product;
import com.example.baitap1.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepo iProductRepo;
    @Override
    public List<Product> showProduct() {
        return iProductRepo.showProduct();
    }

    @Override
    public void addProduct(Product product) {
    iProductRepo.addProduct(product);
    }

    @Override
    public void updateProduct(int id, Product product) {
        iProductRepo.updateProduct(id,product);
    }

    @Override
    public void deleteProduct(int id) {
    iProductRepo.deleteProduct(id);
    }

    @Override
    public Product getProduct(int id) {
        return iProductRepo.getProduct(id);
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        return iProductRepo.searchProduct(nameProduct);
    }
}
