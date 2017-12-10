package com.krishna.spring.boot.jpa.service;

import com.krishna.spring.boot.jpa.dao.ArticleDAO;
import com.krishna.spring.boot.jpa.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ArticleServiceJDBCImpl")
public class ArticleServiceJDBCImpl implements ArticleService {

    private ArticleDAO articleDAO;

    public ArticleServiceJDBCImpl(ArticleDAO articleDAO) {
        this.articleDAO = articleDAO;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleDAO.getAllArticles();
    }

    @Override
    public Article getArticleById(int articleId) {
        return articleDAO.getArticleById(articleId);
    }

    @Override
    public Article addArticle(Article article) {
        return articleDAO.addArticle(article);
    }

    @Override
    public Article updateArticle(Article article) {
        return articleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        articleDAO.deleteArticle(articleId);
    }
}
