package com.example.demo.service;

import com.example.demo.model.Classroom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassroomService {
    List<Classroom> findAllClassroom();

    Page<Classroom> findAllAllClassRoom(Pageable pageable);

    void createClassRoom(Classroom classroom);

    void updateClassRoom(Classroom classroom);

    void deleteClassRoom(Integer id);

    Classroom findByIdClassroom(Integer id);
}
