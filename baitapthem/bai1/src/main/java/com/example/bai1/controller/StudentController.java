package com.example.bai1.controller;

import com.example.bai1.model.Student;
import com.example.bai1.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping public class StudentController {
    @Autowired
    private IStudentService iStudentService;
    @GetMapping
    public ModelAndView showHome(){
        return  new ModelAndView("/index","students",iStudentService.showStudent());
    }
    @GetMapping("/student/add")
    public ModelAndView shoFormAdd(){
        return  new ModelAndView("/add","student",new Student());
    }
    @PostMapping("/student/add")
    public ModelAndView saveStudent(@ModelAttribute Student student){
        int id = 0;
        for (Student student1 : iStudentService.showStudent()){
            id = student1.getId();
        }
        student.setId(id + 1);
        iStudentService.addStudent(student);
        return  new ModelAndView("redirect:/");
    }
    @GetMapping("/student/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable int id){
        Student student = iStudentService.getStudent(id);
        return new ModelAndView("/edit","student",student);
    }
    @PostMapping("/student/{id}/edit")
    public  ModelAndView updateStudent(@ModelAttribute Student student,@PathVariable int id){
        iStudentService.updateStudent(id,student);
        return new ModelAndView("redirect:/","student",student);
    }
    @GetMapping("/student/{id}/view")
    public ModelAndView showViewStudent(@PathVariable int id){
        Student student  = iStudentService.getStudent(id);
        return new ModelAndView("/view","student",student);
    }
    @PostMapping("/student/search")
    public ModelAndView shoResultSearch(@RequestParam(value = "name-search")String nameSearch){
        List<Student> students = iStudentService.searchStudent(nameSearch);
        return  new ModelAndView("/index","students",students);
    }
    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable int id){
        iStudentService.deleteStudent(id);
        return "redirect:/";
    }

}
