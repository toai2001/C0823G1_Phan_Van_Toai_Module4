package com.example.demo.service;


import com.example.demo.model.Cage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICageService {
    List<Cage> findAllCage();
    Page<Cage> findAllCage(Pageable pageable);
    void createCage(Cage cage);
    void updateCage(Cage cage);
    void deleteCage(Integer id);
    Cage findCageById(Integer id);
}
