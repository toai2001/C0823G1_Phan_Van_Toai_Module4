package com.example.controller;

import com.example.model.MailBox;
import com.example.service.IMailBoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/setting")
public class MailBoxController {
    @Autowired
    private IMailBoxService iMailBoxService;

    @GetMapping("/setting")
    public String showSettings(Model model) {
        model.addAttribute("mailbox", iMailBoxService.getMailbox());
        return "/setting";
    }

    @PostMapping("/save")
    public ModelAndView saveSettings(@ModelAttribute MailBox mailBox) {
        iMailBoxService.updateMailbox(mailBox);
        return new ModelAndView("redirect:/setting");
    }
}
