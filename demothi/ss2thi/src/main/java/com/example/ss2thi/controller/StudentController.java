package com.example.ss2thi.controller;

import com.example.ss2thi.model.Student;
import com.example.ss2thi.service.IClassRoomService;
import com.example.ss2thi.service.IStudentService;
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
    IStudentService iStudentService;
    @Autowired
    IClassRoomService iClassRoomServicel;

    @GetMapping("student/list")
    public ModelAndView showHome(
            @RequestParam(value = "nameSearch", defaultValue = "") String nameSearch,
            @PageableDefault(value = 2, sort = "name", direction = Sort.Direction.DESC) Pageable pageable, Model model
    ) {
        model.addAttribute("nameSearch", nameSearch);
        if (!nameSearch.isEmpty()) {
            return new ModelAndView("list", "students", iStudentService.searchStudentByNameContaining(nameSearch, pageable));
        } else {
            return new ModelAndView("list", "students", iStudentService.findAllStudent(pageable));
        }
    }

    @GetMapping("/student/add")
    public ModelAndView showFormAdd(Model model) {
        model.addAttribute("classRoom", iClassRoomServicel.findAllClass());
        return new ModelAndView("add", "student", new Student());
    }

    @PostMapping("/student/add")
    public String saveStudent(@ModelAttribute Student student) {
        iStudentService.createStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping("/student/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("classRoom", iClassRoomServicel.findAllClass());
        return new ModelAndView("edit", "student", iStudentService.findStudentById(id));
    }

    @PostMapping("/student/{id}/edit")
    public String updatePig(@ModelAttribute Student student) {
        iStudentService.updateStudent(student);
        return "redirect:/student/list";
    }

    @GetMapping("/student/{id}/delete")
    public String deleteBlog(@PathVariable Integer id) {
        iStudentService.deleteStudent(id);
        return "redirect:/student/list";
    }

    @GetMapping("/student/{id}/view")
    public ModelAndView viewDetailPig(@PathVariable Integer id) {
        return new ModelAndView("view", "student", iStudentService.findStudentById(id));
    }
}
