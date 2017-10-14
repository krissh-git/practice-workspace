package com.poc.springangular2hibernatemysql.controller;

import com.poc.springangular2hibernatemysql.model.Article;
import com.poc.springangular2hibernatemysql.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("api")
@CrossOrigin(origins = "http://localhost:4200")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("article")
    public ResponseEntity<Void> createArticle(@RequestBody Article article, UriComponentsBuilder builder) {
        boolean status = articleService.createArticle(article);
        if (status) {
            HttpHeaders httpHeaders = new HttpHeaders();
            URI uri = builder.path("/article?id={id}").buildAndExpand(article.getArticleId()).toUri();
            httpHeaders.setLocation(uri);
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
        }

        return new ResponseEntity<>(HttpStatus.CONFLICT);
    }

    @PutMapping("article")
    public ResponseEntity<Article> updateArticle(@RequestBody Article article) {
        articleService.updateArticle(article);
        return new ResponseEntity<>(article, HttpStatus.OK);
    }

    @DeleteMapping("article")
    public ResponseEntity<Void> deleteArticle(@RequestParam("id") int articleId) {
        articleService.deleteArticle(articleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("article")
    public ResponseEntity<Article> getArticleById(@RequestParam("id") int articleId) {
        Article articleById = articleService.getArticleById(articleId);
        return new ResponseEntity<>(articleById, HttpStatus.OK);
    }

    @GetMapping("article/all")
    public ResponseEntity<List<Article>> getArticles() {
        List<Article> articles = articleService.getArticles();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }


}
