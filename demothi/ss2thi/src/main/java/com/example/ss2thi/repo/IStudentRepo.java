package com.example.ss2thi.repo;

import com.example.ss2thi.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Integer> {
    @Query(nativeQuery = true,value = "select * from pig where id_classRoom = :param")
    List<Student> getStudentsByClassRoom(@Param("param") Integer idClassRoom);
    Page<Student> searchStudentByNameContaining(String name, Pageable pageable);
}
