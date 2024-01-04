package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.IClassroomService;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class StudentController {
    @Autowired
    private IClassroomService iClassroomService;
    @Autowired
    private IStudentService iStudentService;

//    @GetMapping
//    public ModelAndView showHome() {
//        return new ModelAndView("index", "students", iStudentService.findAllStudent());
//    }

    @GetMapping
    public ModelAndView showList(@PageableDefault(value = 2, sort = "age", direction = Sort.Direction.DESC) Pageable pageable) {
        return new ModelAndView("list", "student", iStudentService.findAllStudent(pageable));
    }

    @GetMapping("/student/add")
    public ModelAndView showFormAdd(Model model) {
        model.addAttribute("classroom", iClassroomService.findAllClassroom());
        return new ModelAndView("add", "student", new Student());
    }

    @PostMapping("/student/add")
    public String saveStudent(@ModelAttribute Student student) {
        iStudentService.createStudent(student);
        return "redirect:/";
    }

    @GetMapping("/student/{id}/view")
    public ModelAndView viewDetailStudent(@PathVariable Integer id) {
        return new ModelAndView("view", "student", iStudentService.findStudentById(id));
    }
    @GetMapping("/student/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id , Model model){
        model.addAttribute("classroom",iClassroomService.findAllClassroom());
        return new ModelAndView("edit","student",iStudentService.findStudentById(id));
    }
    @PostMapping("/student/{edit}/edit")
    public String updateStudent(@ModelAttribute Student student){
        iStudentService.updateStudent(student);
        return "redirect:/";
    }
    @GetMapping("/student/{id}/delete")
    public String deleteStudent(@PathVariable Integer id){
        iStudentService.deleteStudent(id);
          return "redirect:/";
    }
    @PostMapping("/student/search")
    public ModelAndView searchByTitle(@RequestParam(value = "name-search") String name) {
        return new ModelAndView("list", "student", iStudentService.getStudentByNameContaining(name));
    }

}
