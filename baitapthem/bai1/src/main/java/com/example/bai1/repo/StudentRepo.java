package com.example.bai1.repo;

import com.example.bai1.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo implements IStudentRepo {
    private final static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Trần Anh Tuấn", "Nam", 18, "Đà Nẵng"));
        students.add(new Student(2, "Nguyễn Minh TUấn", "Nam", 18, "Đà Nẵng"));
        students.add(new Student(3, "Phan Văn Toại", "Nam", 22, "Nghệ An"));
        students.add(new Student(4, "Trần Linh Giang", "Nam", 22, "Quảng Bình"));
        students.add(new Student(5, "Phạm Văn Thành", "Nam", 22, "Nghệ An"));

    }

    @Override
    public List<Student> showStudent() {
        return students;
    }

    @Override
    public void addStudent(Student student) {

        students.add(student);

    }

    @Override
    public void updateStudent(int id, Student student) {
        int index;
        for (Student value : students) {
            if (value.getId() == id) {
                index = students.indexOf(value);
                students.set(index, student);
            }
        }
    }

    @Override
    public void deleteStudent(int id) {
        students.remove(getStudent(id));
    }

    @Override
    public Student getStudent(int id) {
        for (Student value : students) {
            if (value.getId() == id) {
                return value;
            }
        }
        return null;
    }

    @Override
    public List<Student> searchStudent(String nameStudent) {
        List<Student> studentList = new ArrayList<>();
        System.out.println(nameStudent);
        for (Student value : students) {
            if (value.getName().contains(nameStudent)) {
                studentList.add(value);
            }
        }
        return studentList;
    }
}
