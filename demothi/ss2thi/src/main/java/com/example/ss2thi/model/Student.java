package com.example.ss2thi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    private String gender;
    private String address;
    private double height;
    private double weight;
    @ManyToOne()
    @JoinColumn(name = "id_classRoom", referencedColumnName = "id")
    private ClassRoom classRoom;
}
