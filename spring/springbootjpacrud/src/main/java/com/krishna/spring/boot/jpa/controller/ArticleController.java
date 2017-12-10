package com.krishna.spring.boot.jpa.controller;

import com.krishna.spring.boot.jpa.entity.Article;
import com.krishna.spring.boot.jpa.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("crud")
public class ArticleController {

    @Autowired
    @Qualifier("ArticleServiceJDBCImpl")
    private ArticleService articleService;

    @GetMapping("articles")
    public List<Article> getArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("article/{id}")
    public Article getArticles(@PathVariable("id") Integer id) {
        return articleService.getArticleById(id);
    }


    @PostMapping("article")
    public Article addArticle(@RequestBody Article article) {
        return articleService.addArticle(article);
    }

    @PutMapping("article")
    public Article updateArticle(@RequestBody Article article) {
        return articleService.updateArticle(article);
    }

    @DeleteMapping("article/{id}")
    public void deleteArticle(@PathVariable("id") Integer id) {
        articleService.deleteArticle(id);
    }


}
