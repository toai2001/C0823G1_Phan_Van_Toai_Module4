package com.example.demothiss2.model;

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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String age;
    private String address;
    private String gender;
    private long height;
    private long weight;
    @ManyToOne()
    @JoinColumn(name = "id_classRoom", referencedColumnName = "id")
    private ClassRoom classRoom;

}
