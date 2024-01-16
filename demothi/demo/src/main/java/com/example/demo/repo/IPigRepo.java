package com.example.demo.repo;

import com.example.demo.model.Pig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPigRepo extends JpaRepository<Pig,Integer> {
    @Query(nativeQuery = true,value = "select * from pig where id_cage = :param")
    List<Pig> getPigByCageId(@Param("param") Integer idCage);
    Page<Pig> searchPigByTenLonContaining(String tenLon, Pageable pageable);
}
