package com.example.bai1.dto;

import com.example.bai1.model.Product;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<Product,Integer> products= new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<Product, Integer> products) {
        this.products = products;
    }
    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
    private boolean checkItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product, Integer> selectItemInCart(Product product){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if(entry.getKey().getId().equals(product.getId())){
                return entry;
            }
        }
        return null;
    }

    public void addProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItemInCart(product);
            Integer newQuantity = itemEntry.getValue() + 1;
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }

    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }

    public void plusCountProduct(Long idProduct){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == idProduct) {
                products.replace(entry.getKey(),entry.getValue()+1);
            }
        }
    }

    public void decreaseCountProduct(Long idProduct){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == idProduct) {
                products.replace(entry.getKey(),entry.getValue() - 1);
            }
        }
    }

    public void deleteToCard(Long idProduct){
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            if (entry.getKey().getId() == idProduct) {
                products.remove(entry.getKey());
            }
        }
    }
}
