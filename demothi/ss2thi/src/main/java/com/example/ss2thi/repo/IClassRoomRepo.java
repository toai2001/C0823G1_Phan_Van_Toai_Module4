package com.example.ss2thi.repo;

import com.example.ss2thi.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassRoomRepo extends JpaRepository<ClassRoom,Integer> {
}
