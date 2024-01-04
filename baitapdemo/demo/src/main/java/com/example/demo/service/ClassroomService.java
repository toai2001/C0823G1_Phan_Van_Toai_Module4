package com.example.demo.service;

import com.example.demo.model.Classroom;
import com.example.demo.repo.IClassroomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService implements IClassroomService {
    @Autowired
    private IClassroomRepo iClassroomRepo;

    @Override
    public List<Classroom> findAllClassroom() {
        return iClassroomRepo.findAll();
    }

    @Override
    public Page<Classroom> findAllAllClassRoom(Pageable pageable) {
        return iClassroomRepo.findAll(pageable);
    }

    @Override
    public void createClassRoom(Classroom classroom) {
        iClassroomRepo.save(classroom);
    }

    @Override
    public void updateClassRoom(Classroom classroom) {
        iClassroomRepo.save(classroom);
    }

    @Override
    public void deleteClassRoom(Integer id) {
        iClassroomRepo.delete(findByIdClassroom(id));

    }

    @Override
    public Classroom findByIdClassroom(Integer id) {
        return iClassroomRepo.findById(id).get();
    }
}
