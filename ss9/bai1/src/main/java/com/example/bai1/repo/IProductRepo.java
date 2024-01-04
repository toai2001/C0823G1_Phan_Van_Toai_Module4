package com.example.bai1.repo;

import com.example.bai1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product,Long> {
}
