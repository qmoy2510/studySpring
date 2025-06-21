package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.entity.Article;
import com.example.firstProject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/article/new")
    public String newArticleFomr () {
        return "articles/new";
    }

    @PostMapping("/article/create")
    public String createArticle (ArticleForm form) {
        System.out.println(form.toString());
        //1. DTO 를 엔티티로 변환
        Article article = form.toEntity();
        System.out.println(article.toString());

        //2. 레포지터리로 엔티티를 db에 저장
        Article saved = articleRepository.save(article);
        System.out.println(saved.toString());
        return "";
    }
}
