package com.example.demo.repo;

import com.example.demo.model.Cage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

@Repository
public interface ICageRepo extends JpaRepository<Cage,Integer> {
}
