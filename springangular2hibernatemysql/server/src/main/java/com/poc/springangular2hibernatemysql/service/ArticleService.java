package com.poc.springangular2hibernatemysql.service;

import com.poc.springangular2hibernatemysql.model.Article;

import java.util.List;

public interface ArticleService {

    boolean createArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(int articleId);

    Article getArticleById(int articleId);

    List<Article> getArticles();

    boolean articleExists(String title, String category);
}
