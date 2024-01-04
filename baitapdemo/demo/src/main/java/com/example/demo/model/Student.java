package com.example.demo.model;

import jakarta.persistence.*;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String gender;
    private int age;
    private String address;
    @ManyToOne
    @JoinColumn(name = "id_classroom",referencedColumnName = "id")
    private Classroom classroom;

    public Student() {
    }

    public Student(Integer id, String name, String gender, int age, String address, Classroom classroom) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.address = address;
        this.classroom = classroom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
