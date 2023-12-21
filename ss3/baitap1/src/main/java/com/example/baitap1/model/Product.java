package com.example.baitap1.model;

public class Product {
    private  int id;
    private  String name;
    private  String description;
    private Long price;
    private String producer;

    public Product() {
    }

    public Product(int id, String name, String description, Long price, String producer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.producer = producer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
