package com.example.ss2thi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "classRoom_student")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameClass;
    @OneToMany(mappedBy = "classRoom")
    private Set<Student> students;

}
