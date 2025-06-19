package com.example.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {
    String name = "박현빈";
   @GetMapping("/")
   public String hello(Model model) {
           model.addAttribute("name", name);
        return "greetings";
    }   
    @GetMapping("/bye")
    public String bye(Model model) {
           model.addAttribute("name", name);
        return "by ebye";
    }
}
