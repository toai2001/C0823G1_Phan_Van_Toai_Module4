package com.example.ss2thi.controller;

import com.example.ss2thi.model.ClassRoom;
import com.example.ss2thi.repo.IClassRoomRepo;
import com.example.ss2thi.service.IClassRoomService;
import com.example.ss2thi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/classRoom")
public class ClassRoomController {
    @Autowired
    private IClassRoomService iClassRoomService;
    @Autowired
    private IStudentService iStudentService;
    @GetMapping("/list")
    public ModelAndView showListClass(@PageableDefault(value = 2) Pageable pageable){
        return new ModelAndView("classRoom-list","classRoom",iClassRoomService.findAllClass(pageable));
    }
    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("add-classRoom", "classRoom", new ClassRoom());
    }

    @PostMapping("/add")
    public String saveClassRoom(@ModelAttribute ClassRoom classRoom) {
        iClassRoomService.createClass(classRoom);
        return "redirect:/classRoom/list";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id) {
        return new ModelAndView("edit-classRoom", "classRoom", iClassRoomService.findClasById(id));
    }

    @PostMapping("/{id}/edit")
    public String updateClassRoom(@ModelAttribute ClassRoom classRoom) {
        iClassRoomService.updateClass(classRoom);
        return "redirect:/classRoom/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteCage(@PathVariable Integer id){
        iClassRoomService.deleteCage(id);
        return "redirect:/classRoom/list";
    }
}
