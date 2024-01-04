package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repo.IStudentRepo;
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
    public List<Student> getClassRoomById(Integer classroomId) {
        return iStudentRepo.getStudentById(classroomId);
    }

    @Override
    public List<Student> getStudentByNameContaining(String name) {
        return iStudentRepo.searchStudentByNameContaining(name);
    }
}
