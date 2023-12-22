package com.example.bai1.service;

import com.example.bai1.model.Student;
import com.example.bai1.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService{
    @Autowired
    private IStudentRepo iStudentRepo;
    @Override
    public List<Student> showStudent() {
        return iStudentRepo.showStudent();
    }

    @Override
    public void addStudent(Student student) {
iStudentRepo.addStudent(student);
    }

    @Override
    public void updateStudent(int id, Student student) {
iStudentRepo.updateStudent(id,student);
    }

    @Override
    public void deleteStudent(int id) {
iStudentRepo.deleteStudent(id);
    }

    @Override
    public Student getStudent(int id) {
        return iStudentRepo.getStudent(id);
    }

    @Override
    public List<Student> searchStudent(String nameStudent) {
        return iStudentRepo.searchStudent(nameStudent);
    }
}
