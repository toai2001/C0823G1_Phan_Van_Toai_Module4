package com.example.baitap1.controller;

import com.example.baitap1.model.Product;
import com.example.baitap1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public ModelAndView showHome() {
        return new ModelAndView("/index", "products", iProductService.showProduct());
    }

    @GetMapping("/product/add")
    public ModelAndView showFormAdd() {
        return new ModelAndView("/add", "product", new Product());
    }

    @PostMapping("/product/add")
    public ModelAndView saveProduct(@ModelAttribute Product product) {
        iProductService.addProduct(product);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/product/{id}/edit")
    public ModelAndView fromEdit(@PathVariable int id) {
        Product product = iProductService.getProduct(id);
        return new ModelAndView("/edit", "product", product);
    }
    @PostMapping("product/{id}/edit")
    public ModelAndView updateProduct(@ModelAttribute Product product,@PathVariable int id){
        iProductService.updateProduct(id, product);
        return new ModelAndView("redirect:/","product",product);
    }
    @GetMapping("product/{id}/view")
    public  ModelAndView showViewProduct(@PathVariable int id){
        Product product  = iProductService.getProduct(id);
        return new ModelAndView("/view","product",product);
    }
    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable int id){
        iProductService.deleteProduct(id);
        return "redirect:/";
    }
    @PostMapping("/product/search")
    public ModelAndView showResultSearch(@RequestParam(value = "name-search") String nameSearch){
        List<Product> products = iProductService.searchProduct(nameSearch);
        return new ModelAndView("/index","products",products);
    }



}
