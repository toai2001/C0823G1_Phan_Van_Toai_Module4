package com.example.baitap2.controller;

import com.example.baitap2.service.DictionaryService;
import com.example.baitap2.service.IDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping
    ModelAndView showHome() {
        return new ModelAndView("/index");
    }
    @GetMapping("/transalte")
    public ModelAndView display(Model model, String eng) {
        model.addAttribute("eng", eng);
        model.addAttribute("vi", iDictionaryService.display(eng));
        return new ModelAndView("/index");
    }
}
