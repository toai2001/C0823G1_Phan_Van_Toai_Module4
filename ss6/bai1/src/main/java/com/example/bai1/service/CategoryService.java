package com.example.bai1.service;

import com.example.bai1.model.Category;
import com.example.bai1.repo.ICategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService{
    @Autowired
    private ICategoryRepo iCategoryRepo;
    @Override
    public List<Category> findAllCategory() {
        return iCategoryRepo.findAll() ;
    }

    @Override
    public Page<Category> findAllCategory(Pageable pageable) {
        return iCategoryRepo.findAll(pageable);
    }

    @Override
    public void createCategory(Category category) {
        iCategoryRepo.save(category);
    }

    @Override
    public void updateCategory(Category category) {
        iCategoryRepo.save(category);
    }

    @Override
    public void deleteCategory(Integer id) {
iCategoryRepo.delete(findCategoryById(id));
    }

    @Override
    public Category findCategoryById(Integer id) {
        return iCategoryRepo.findById(id).get();
    }
}
