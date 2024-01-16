package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tenLon;
    private Long trongLuong;
    private int tuoi;
    private String gioiTinh;
    @ManyToOne()
    @JoinColumn(name = "id_cage", referencedColumnName = "id")
    private Cage cage;
}
