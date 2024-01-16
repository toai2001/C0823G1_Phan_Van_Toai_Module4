package com.example.demo.controller;

import com.example.demo.model.Cage;
import com.example.demo.service.ICageService;
import com.example.demo.service.IPig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cage")
public class CageController {
    @Autowired
    private ICageService iCageService;
    @Autowired
    private IPig iPig;
    @GetMapping("/list")
    public ModelAndView showListCage(@PageableDefault(value = 2)Pageable pageable){
        return new ModelAndView("cage-list","cage",iCageService.findAllCage(pageable));
    }
    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("add-cage", "cage", new Cage());
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute Cage cage) {
        iCageService.createCage(cage);
        return "redirect:/cage/list";
    }
    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id) {
        return new ModelAndView("edit-cage", "cage", iCageService.findCageById(id));
    }

    @PostMapping("/{id}/edit")
    public String updateCategory(@ModelAttribute Cage cage) {
        iCageService.updateCage(cage);
        return "redirect:/cage/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteCage(@PathVariable Integer id){
        iCageService.deleteCage(id);
        return "redirect:/cage/list";
    }

}
