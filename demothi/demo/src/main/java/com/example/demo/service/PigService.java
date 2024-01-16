package com.example.demo.service;

import com.example.demo.model.Pig;
import com.example.demo.repo.IPigRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PigService implements IPig {
    @Autowired
    private IPigRepo iPigRepo;

    @Override
    public Page<Pig> findAllPig(Pageable pageable) {
        return iPigRepo.findAll(pageable);
    }

    @Override
    public List<Pig> findAllPig() {
        return iPigRepo.findAll();
    }

    @Override
    public void createPig(Pig pig) {
        iPigRepo.save(pig);
    }

    @Override
    public Pig findPigById(Integer id) {
        return iPigRepo.findById(id).get();
    }

    @Override
    public void updatePig(Pig pig) {
        iPigRepo.save(pig);
    }

    @Override
    public void deletePig(Integer id) {
        iPigRepo.deleteById(id);
    }

    @Override
    public List<Pig> getPigByCageId(Integer cageId) {
        return iPigRepo.getPigByCageId(cageId);
    }

    @Override
    public Page<Pig> searchPigByTenLonContaining(String tenLon,Pageable pageable) {
        return iPigRepo.searchPigByTenLonContaining(tenLon,pageable);
    }
}
