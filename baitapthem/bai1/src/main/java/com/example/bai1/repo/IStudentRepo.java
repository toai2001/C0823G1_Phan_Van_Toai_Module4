package com.example.bai1.repo;

import com.example.bai1.model.Student;

import java.util.List;

public interface IStudentRepo {
    List<Student> showStudent();

    void addStudent(Student student);

    void updateStudent(int id, Student student);

    void deleteStudent(int id);

    Student getStudent(int id);

    List<Student> searchStudent(String nameStudent);
}
