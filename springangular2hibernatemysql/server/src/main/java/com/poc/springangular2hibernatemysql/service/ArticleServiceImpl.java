package com.poc.springangular2hibernatemysql.service;

import com.poc.springangular2hibernatemysql.dao.ArticleDao;
import com.poc.springangular2hibernatemysql.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;


    @Override
    public synchronized boolean createArticle(Article article) {
        if (articleExists(article.getTitle(), article.getCategory())) {
            return false;
        }
        articleDao.createArticle(article);
        return true;
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);

    }

    @Override
    public void deleteArticle(int articleId) {
        articleDao.deleteArticle(articleId);
    }

    @Override
    public Article getArticleById(int articleId) {
        return articleDao.getArticleById(articleId);
    }

    @Override
    public List<Article> getArticles() {
        return articleDao.getArticles();
    }

    @Override
    public boolean articleExists(String title, String category) {
        return articleDao.articleExists(title, category);
    }
}
