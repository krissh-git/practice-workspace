package com.krishna.spring.boot.jpa.service;

import com.krishna.spring.boot.jpa.entity.Article;
import com.krishna.spring.boot.jpa.repository.ArticleRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        List<Article> articles = new ArrayList<>();
        articleRepository.findAll().forEach(articles::add);
        return articles;
    }

    public Article getArticleById(int articleId) {
        return articleRepository.findOne(articleId);
    }

    public synchronized Article addArticle(Article article) {
        final List<Article> byTitleAndCategory = articleRepository.findByTitleAndCategory(article.getTitle(), article.getCategory());
        if (!CollectionUtils.isEmpty(byTitleAndCategory)) {
            return null;
        }
        return articleRepository.save(article);
    }


    public Article updateArticle(Article article) {
        return articleRepository.save(article);
    }

    public void deleteArticle(int articleId) {
        articleRepository.delete(articleId);
    }

}
