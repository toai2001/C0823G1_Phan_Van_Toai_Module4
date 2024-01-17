package com.example.ss2thi.service;

import com.example.ss2thi.model.Student;
import com.example.ss2thi.repo.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepo iStudentRepo;

    @Override
    public Page<Student> findAllStudent(Pageable pageable) {
        return iStudentRepo.findAll(pageable);
    }

    @Override
    public List<Student> findAllStudent() {
        return iStudentRepo.findAll();
    }

    @Override
    public void createStudent(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public Student findStudentById(Integer id) {
        return iStudentRepo.findById(id).get();
    }

    @Override
    public void updateStudent(Student student) {
        iStudentRepo.save(student);
    }

    @Override
    public void deleteStudent(Integer id) {
        iStudentRepo.deleteById(id);
    }

    @Override
    public List<Student> getStudentsByClassRoom(Integer classId) {
        return iStudentRepo.getStudentsByClassRoom(classId);
    }

    @Override
    public Page<Student> searchStudentByNameContaining(String name, Pageable pageable) {
        return iStudentRepo.searchStudentByNameContaining(name, pageable);
    }
}
