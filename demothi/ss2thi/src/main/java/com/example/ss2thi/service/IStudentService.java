package com.example.ss2thi.service;

import com.example.ss2thi.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IStudentService {
    Page<Student> findAllStudent(Pageable pageable);

    List<Student> findAllStudent();

    void createStudent(Student student);

    Student findStudentById(Integer id);

    void updateStudent(Student student);

    void deleteStudent(Integer id);

    List<Student> getStudentsByClassRoom    (Integer classId);

    Page<Student> searchStudentByNameContaining(String name,Pageable pageable);
}
