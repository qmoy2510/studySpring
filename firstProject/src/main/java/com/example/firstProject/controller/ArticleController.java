package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.entity.Article;
import com.example.firstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.asm.IModelFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/article/new")
    public String newArticleFomr () {
        return "articles/new";
    }

    @GetMapping("/article/{id}")
    public String show(@PathVariable Long id , Model model) {
        log.info("id = " +id);
        //1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        //2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);
        //3. 뷰 페이지 반환하기
        return "articles/show";
    }

    @PostMapping("/article/create")
    public String createArticle (ArticleForm form) {
        log.info(form.toString());
        //1. DTO 를 엔티티로 변환
        Article article = form.toEntity();
        log.info(article.toString());

        //2. 레포지터리로 엔티티를 db에 저장
        Article saved = articleRepository.save(article);
        log.info(saved.toString());
        return "";
    }
}
