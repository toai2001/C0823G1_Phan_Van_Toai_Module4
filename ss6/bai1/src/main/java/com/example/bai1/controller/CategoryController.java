package com.example.bai1.controller;

import com.example.bai1.model.Category;
import com.example.bai1.service.IBlogService;
import com.example.bai1.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/list")
    public ModelAndView showListCategory(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("category-list", "category", iCategoryService.findAllCategory(pageable));
    }

    @GetMapping("/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("add-category", "category", new Category());
    }

    @PostMapping("/add")
    public String saveCategory(@ModelAttribute Category category) {
        iCategoryService.createCategory(category);
        return "redirect:/category/list";
    }

    @GetMapping("/{id}/view")
    public String viewDetailCategory(Model model, @PathVariable Integer id) {
        model.addAttribute("category", iCategoryService.findCategoryById(id));
        model.addAttribute("blogs", iBlogService.getBlogByCategoryId(id));
        return "view-category";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id) {
        return new ModelAndView("edit-category", "category", iCategoryService.findCategoryById(id));
    }

    @PostMapping("/{id}/edit")
    public String updateCategory(@ModelAttribute Category category) {
        iCategoryService.updateCategory(category);
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String deleteCategory(@PathVariable Integer id){
        iCategoryService.deleteCategory(id);
        return "redirect:/category/list";
    }

}
