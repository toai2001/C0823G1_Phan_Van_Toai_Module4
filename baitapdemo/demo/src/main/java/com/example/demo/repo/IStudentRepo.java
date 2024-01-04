package com.example.demo.repo;

import com.example.demo.model.Classroom;
import com.example.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepo extends JpaRepository<Student,Integer> {
    @Query(nativeQuery = true,value = "select * from student where id_classroom = :param")
    List<Student> getStudentById(@Param("param") Integer idClassroom);
    List<Student> searchStudentByNameContaining(String name);
}

