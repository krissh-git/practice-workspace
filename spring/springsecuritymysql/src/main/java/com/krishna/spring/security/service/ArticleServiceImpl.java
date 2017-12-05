package com.krishna.spring.security.service;

import com.krishna.spring.security.dao.IArticleDAO;
import com.krishna.spring.security.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    private IArticleDAO iArticleDAO;

    @Override
    public List<Article> getAllArticles() {
        return iArticleDAO.getAllArticles();
    }

    @Override
    public Article getArticleById(int articleId) {
        return iArticleDAO.getArticleById(articleId);
    }

    @Override
    public synchronized boolean addArticle(Article article) {
        if (iArticleDAO.articleExists(article.getTitle(), article.getCategory())) {
            return false;
        } else {
            iArticleDAO.addArticle(article);
        }
        return true;
    }

    @Override
    public void updateArticle(Article article) {
        iArticleDAO.updateArticle(article);
    }

    @Override
    public void deleteArticle(int articleId) {
        iArticleDAO.deleteArticle(articleId);
    }
}
