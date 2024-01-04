package com.example.demo.controller;

import com.example.demo.service.IClassroomService;
import com.example.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private IClassroomService iClassroomService;
    @Autowired
    private IStudentService iStudentService;

}
