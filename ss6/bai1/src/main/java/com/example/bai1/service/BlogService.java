package com.example.bai1.service;

import com.example.bai1.model.Blog;
import com.example.bai1.repo.IBlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepo iBlogRepo;
    @Override
    public Page<Blog> findAllBlog(Pageable pageable) {
        return iBlogRepo.findAll(pageable);
    }

    @Override
    public List<Blog> findAllBlog() {
        return iBlogRepo.findAll();
    }

    @Override
    public void crateBlog(Blog blog) {
        iBlogRepo.save(blog);
    }

    @Override
    public String getSummaryById(Integer id) {
//        return  null;
        return iBlogRepo.getSummaryById(id);
    }

    @Override
    public Blog findBlogById(Integer id) {
        return iBlogRepo.findById(id).get();
    }

    @Override
    public void updateBlog(Blog blog) {
        iBlogRepo.save(blog);
    }

    @Override
    public void deleteBlog(Integer id) {
        iBlogRepo.deleteById(id);
    }

    @Override
    public List<Blog> getBlogByCategoryId(Integer categoryId) {
//        return  null;
        return iBlogRepo.getBlogByCategoryId(categoryId);
    }

    @Override
    public List<Blog> searchBlogByTitleContaining(String title) {
//        return  null;
        return iBlogRepo.searchBlogByTitleContaining(title);
    }
}
