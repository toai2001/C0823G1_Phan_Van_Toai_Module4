package com.example.demo_spring_boot.repository;

import com.example.demo_spring_boot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepo extends JpaRepository<Student,Integer> {
}
