package com.example.bai1.controller;

import com.example.bai1.model.Product;
import com.example.bai1.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping
    public ModelAndView showHome(){
        return new ModelAndView("index","product",iProductService.showAllProduct());
    }
    @GetMapping("/product/add")
    public ModelAndView showFormAddProduct() {
        return new ModelAndView("add", "product", new Product());
    }
    @PostMapping ("/product/add")
    public String saveProduct(@ModelAttribute Product product){
        iProductService.addProduct(product);
        return "redirect:/";
    }
    @GetMapping("/product/{id}/view")
    public ModelAndView showViewProduct(@PathVariable Integer id){
        Product product = iProductService.getProduct(id);
        return new ModelAndView("view","product", product);
    }
    @GetMapping("/product/{id}/edit")
    public ModelAndView showFormEditProduct(@PathVariable Integer id){
        Product product = iProductService.getProduct(id);
        return new ModelAndView("edit","product", product);
    }

    @PostMapping("/product/{id}/edit")
    public ModelAndView updateProduct(@ModelAttribute Product product){
        iProductService.updateProduct(product);
        return new ModelAndView("view","product", product);
    }
    @PostMapping("/product/search")
    public ModelAndView showResultSearch(@RequestParam(value = "name-search") String nameSearch){
        List<Product> products = iProductService.searchProduct(nameSearch);
        return new ModelAndView("index","product",products);
    }
    @GetMapping("/product/{id}/delete")
    public String deleteProduct(@PathVariable Integer id){
        iProductService.deleteProduct(id);
        return "redirect:/";
    }



}
