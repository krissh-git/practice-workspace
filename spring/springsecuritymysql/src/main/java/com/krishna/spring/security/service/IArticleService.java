package com.krishna.spring.security.service;

import com.krishna.spring.security.entity.Article;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface IArticleService {
    String ROLE_ADMIN = "ROLE_ADMIN";
    String ROLE_USER = "ROLE_USER";

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    List<Article> getAllArticles();

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    Article getArticleById(int articleId);

    @Secured({"ROLE_ADMIN"})
    boolean addArticle(Article article);

    @Secured({"ROLE_ADMIN"})
    void updateArticle(Article article);

    @Secured({"ROLE_ADMIN"})
    void deleteArticle(int articleId);
}
