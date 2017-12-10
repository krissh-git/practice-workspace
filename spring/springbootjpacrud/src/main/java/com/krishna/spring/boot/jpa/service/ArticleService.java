package com.krishna.spring.boot.jpa.service;

import com.krishna.spring.boot.jpa.entity.Article;

import java.util.List;

public interface ArticleService {


    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    Article addArticle(Article article);

    Article updateArticle(Article article);

    void deleteArticle(int articleId);

}
