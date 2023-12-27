package com.example.bai1.controller;

import com.example.bai1.model.Blog;
import com.example.bai1.service.IBlogService;
import com.example.bai1.service.ICategoryService;
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
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ModelAndView showHome() {
        return new ModelAndView("index", "blogs", iBlogService.findAllBlog());
    }
    @GetMapping("/blog/list")
    public ModelAndView showList(@PageableDefault(value = 2,sort = "timePost",direction = Sort.Direction.DESC) Pageable pageable) {
        return new ModelAndView("list","blogs",iBlogService .findAllBlog(pageable));
    }
    @GetMapping("/blog/add")
    public ModelAndView showFormAdd(Model model) {
        model.addAttribute("category", iCategoryService.findAllCategory());
        return new ModelAndView("add", "blog", new Blog());
    }

    @PostMapping("/blog/add")
    public String savaBlog(@ModelAttribute Blog blog) {
        iBlogService.crateBlog(blog);
        return "redirect:/";
    }

    @GetMapping("/blog/{id}/view")
    public ModelAndView viewDetaiBlog(@PathVariable Integer id) {
        return new ModelAndView("view", "blog", iBlogService.findBlogById(id));
    }

    @GetMapping("/blog/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable Integer id, Model model) {
        model.addAttribute("category", iCategoryService.findAllCategory());
        return new ModelAndView("edit", "blog", iBlogService.findBlogById(id));
    }

    @PostMapping("/blog/{id}/edit")
    public String updateBlog(@ModelAttribute Blog blog) {
        iBlogService.updateBlog(blog);
        return "redirect:/blog/list";
    }

    @GetMapping("/blog/{id}/delete")
    public String deleteBlog(@PathVariable Integer id) {
        iBlogService.deleteBlog(id);
        return "redirect:/blog/list";
    }

    @PostMapping("/blog/search")
    public ModelAndView searchByTitle(@RequestParam(value = "title-search") String titleSearch) {
        return new ModelAndView("index", "blogs", iBlogService.searchBlogByTitleContaining(titleSearch));
    }


}
