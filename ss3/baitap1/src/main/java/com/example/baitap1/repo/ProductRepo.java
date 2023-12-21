package com.example.baitap1.repo;

import com.example.baitap1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private final static List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(1, "Iphone 14", "Iphone 14 Mau Trang 256GB Moi 100%", 1000l,"Apple"));
        products.add(new Product(2, "Iphone 15", "Iphone 15 Mau Trang 128GB Moi 100%", 1200l,"Apple"));
        products.add(new Product(3, "Iphone XS", "Iphone XS Mau Trang 256GB Moi 100%", 500l,"Apple"));
        products.add(new Product(4, "Iphone XS Max", "Iphone XS Max Mau Trang 128GB Moi 100%", 800l,"Apple"));
        products.add(new Product(5, "Iphone 15 Pro Max", "Iphone 15 Pro Max Mau Trang 256GB Moi 100%", 18000l,"Apple"));
    }
    @Override
    public List<Product> showProduct() {
        return products;
    }

    @Override
    public void addProduct(Product product) {
        products.add(product);

    }

    @Override
    public void updateProduct(int id, Product product) {
        int index;
        for (Product value : products) {
            if (value.getId()==id) {
                index = products.indexOf(value);
                products.set(index, product);
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        products.remove(getProduct(id));

    }

    @Override
    public Product getProduct(int id) {
        for (Product value : products) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchProduct(String nameProduct) {
        List<Product> productSearchList = new ArrayList<>();
        for (Product value : products) {
            if (value.getName().contains(nameProduct)) {
                productSearchList.add(value);
            }
        }
        return productSearchList;
    }
}
