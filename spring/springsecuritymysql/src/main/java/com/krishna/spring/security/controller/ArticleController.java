package com.krishna.spring.security.controller;

import com.krishna.spring.security.entity.Article;
import com.krishna.spring.security.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private IArticleService articleService;

    @GetMapping("articles")
    ResponseEntity<List<Article>> getAllArticles() {
        return new ResponseEntity<List<Article>>(articleService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("articles/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") int articleId) {
        return new ResponseEntity<Article>(articleService.getArticleById(articleId), HttpStatus.OK);
    }

    @PostMapping("article")
    public ResponseEntity<Void> addArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        final boolean status = articleService.addArticle(article);
        if (status) {
            new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(builder.buildAndExpand(article.getArticleId()).toUri());
        return new ResponseEntity<Void>(httpHeaders,HttpStatus.CREATED);
    }

    @PutMapping("article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return new ResponseEntity<Article>(HttpStatus.OK);
    }

    @DeleteMapping("article/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") int articleId) {
        articleService.deleteArticle(articleId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
