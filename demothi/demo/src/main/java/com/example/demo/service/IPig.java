package com.example.demo.service;

import com.example.demo.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IPig {
    Page<Pig> findAllPig(Pageable pageable);

    List<Pig> findAllPig();

    void createPig(Pig pig);

    Pig findPigById(Integer id);

    void updatePig(Pig pig);

    void deletePig(Integer id);

    List<Pig> getPigByCageId(Integer cageId);

    Page<Pig> searchPigByTenLonContaining(String tenLon,Pageable pageable);
}
