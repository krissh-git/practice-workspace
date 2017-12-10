package com.krishna.spring.boot.jpa.dao;

import com.krishna.spring.boot.jpa.entity.Article;

import java.util.List;

public interface ArticleDAO {


    List<Article> getAllArticles();

    Article getArticleById(int articleId);

    Article addArticle(Article article);

    Article updateArticle(Article article);

    void deleteArticle(int articleId);
}
