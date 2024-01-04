package com.example.demo.repo;

import com.example.demo.model.Classroom;
import com.example.demo.model.Student;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IClassroomRepo extends JpaRepository<Classroom,Integer> {
}
