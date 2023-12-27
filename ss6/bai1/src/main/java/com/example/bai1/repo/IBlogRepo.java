package com.example.bai1.repo;

import com.example.bai1.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IBlogRepo extends JpaRepository<Blog, Integer> {
    @Query(nativeQuery = true,value = "select summary from blog where id = :param")
    String getSummaryById(@Param("param") Integer id);
    @Query(nativeQuery = true,value = "select * from blog where id_category = :param")
    List<Blog> getBlogByCategoryId(@Param("param") Integer idCategory);
    List<Blog> searchBlogByTitleContaining(String title);
}
