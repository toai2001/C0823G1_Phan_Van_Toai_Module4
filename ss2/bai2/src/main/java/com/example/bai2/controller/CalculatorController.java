package com.example.bai2.controller;

import com.example.bai2.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class CalculatorController {
    @Autowired
    private ICalculatorService iCalculatorService;

    @GetMapping
    public ModelAndView showHome() {
        return new ModelAndView("/index");
    }

    @PostMapping
    public ModelAndView resultForm(@RequestParam(name = "number-a") int numberA,
                                   @RequestParam(name = "number-b") int numberB,
                                   String type) {
        try {
            return new ModelAndView("/index", "result", iCalculatorService.calculator(numberA, numberB, type));

        } catch (ArithmeticException e) {
            return new ModelAndView("/index", "error", "Phép chia số bị chia phải khác 0");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ModelAndView("/index", "error", "Đã có lỗi xảy ra");
        }
    }

}
