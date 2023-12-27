package com.example.bai1.service;

import com.example.bai1.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> findAllCategory();

    Page<Category> findAllCategory(Pageable pageable);

    void createCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Integer id);

    Category findCategoryById(Integer id);
}
