package com.example.demo.controller;

import com.example.demo.model.Pig;
import com.example.demo.service.ICageService;
import com.example.demo.service.IPig;
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
public class PigController {
    @Autowired
    IPig iPig;
    @Autowired
    ICageService iCageService;

    @GetMapping("/pig/list")
    public ModelAndView showHome(
            @RequestParam(value = "tenLonSearch", defaultValue = "") String tenLonSearch,
            @PageableDefault(value = 2, sort = "tenLon", direction = Sort.Direction.DESC) Pageable pageable,Model model) {
        model.addAttribute("tenLonSearch", tenLonSearch);
        if (!tenLonSearch.isEmpty()) {
            return new ModelAndView("list", "pigs", iPig.searchPigByTenLonContaining(tenLonSearch, pageable));
        } else {
            return new ModelAndView("list", "pigs", iPig.findAllPig(pageable));
        }
    }

    @GetMapping("/pig/add")
    public ModelAndView showFormAdd(Model model) {
        model.addAttribute("cage", iCageService.findAllCage());
        return new ModelAndView("add", "pig", new Pig());
    }

    @PostMapping("/pig/add")
    public String saveBlog(@ModelAttribute Pig pig) {
        iPig.createPig(pig);
        return "redirect:/pig/list";
    }
    @GetMapping("/pig/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id, Model model){
        model.addAttribute("cage",iCageService.findAllCage());
        return new ModelAndView("edit","pig", iPig.findPigById(id));
    }
    @PostMapping("/pig/{id}/edit")
    public String updatePig(@ModelAttribute Pig pig){
        iPig.updatePig(pig);
        return "redirect:/pig/list";
    }
    @GetMapping("/pig/{id}/delete")
    public String deleteBlog(@PathVariable Integer id){
        iPig.deletePig(id);
        return "redirect:/pig/list";
    }
    @GetMapping("/pig/{id}/view")
    public ModelAndView viewDetailPig(@PathVariable Integer id){
        return new ModelAndView("view","pig", iPig.findPigById(id));
    }
//    @PostMapping("/pig/search")
//    public ModelAndView searchByTenLon(
//            @RequestParam(value = "tenLonSearch", defaultValue = "") String tenLonSearch,
//            @PageableDefault(value = 2, sort = "tenLon", direction = Sort.Direction.DESC) Pageable pageable, Model model) {
//        model.addAttribute("tenLonSearch", tenLonSearch);
//        return new ModelAndView("list", "pigs", iPig.searchPigByTenLonContaining(tenLonSearch, pageable));
//    }
}
