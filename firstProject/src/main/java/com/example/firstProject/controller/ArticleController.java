package com.example.firstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ArticleController {
    @GetMapping("/article/new")
    public String newArticleFomr () {
        return "articles/new";
    }
}
