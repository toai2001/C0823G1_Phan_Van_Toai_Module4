package com.example.bai1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String lastName;
    private String phoneNumber;
    private int age;
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }

}
