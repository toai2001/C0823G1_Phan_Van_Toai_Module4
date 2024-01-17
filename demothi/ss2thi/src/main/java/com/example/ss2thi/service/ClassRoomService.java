package com.example.ss2thi.service;

import com.example.ss2thi.model.ClassRoom;
import com.example.ss2thi.repo.IClassRoomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ClassRoomService implements IClassRoomService {
    @Autowired
    private IClassRoomRepo iClassRoomRepo;

    @Override
    public List<ClassRoom> findAllClass() {
        return iClassRoomRepo.findAll();
    }

    @Override
    public Page<ClassRoom> findAllClass(Pageable pageable) {
        return iClassRoomRepo.findAll(pageable);
    }

    @Override
    public void createClass(ClassRoom classRoom) {
        iClassRoomRepo.save(classRoom);
    }

    @Override
    public void updateClass(ClassRoom classRoom) {
        iClassRoomRepo.save(classRoom);
    }

    @Override
    public void deleteCage(Integer id) {
        iClassRoomRepo.delete(findClasById(id));
    }

    @Override
    public ClassRoom findClasById(Integer id) {
        return iClassRoomRepo.findById(id).get();
    }
}
