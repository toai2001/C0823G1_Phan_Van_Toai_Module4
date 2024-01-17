package com.example.demo.service;

import com.example.demo.model.Cage;
import com.example.demo.repo.ICageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CageService implements ICageService {
    @Autowired
    private ICageRepo iCageRepo;
    @Override
    public List<Cage> findAllCage() {
        return iCageRepo.findAll();
    }
    @Override
    public Page<Cage> findAllCage(Pageable pageable) {
        return iCageRepo.findAll(pageable);
    }
    @Override
    public void createCage(Cage cage) {
        iCageRepo.save(cage);
    }
    @Override
    public void updateCage(Cage cage) {
        iCageRepo.save(cage);
    }
    @Override
    public void deleteCage(Integer id) {
        iCageRepo.delete(findCageById(id));
    }

    @Override
    public Cage findCageById(Integer id) {
        return iCageRepo.findById(id).get();
    }
}
