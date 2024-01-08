package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Link {
    @GetMapping("/result")
    public String show() {
        return "result";
    }

}
