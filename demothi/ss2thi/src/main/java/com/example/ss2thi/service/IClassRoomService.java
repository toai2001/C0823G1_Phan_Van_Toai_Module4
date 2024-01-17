package com.example.ss2thi.service;

import com.example.ss2thi.model.ClassRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IClassRoomService {
    List<ClassRoom> findAllClass();

    Page<ClassRoom> findAllClass(Pageable pageable);

    void createClass(ClassRoom classRoom);

    void updateClass(ClassRoom classRoom);

    void deleteCage(Integer id);

    ClassRoom findClasById(Integer id);

}
