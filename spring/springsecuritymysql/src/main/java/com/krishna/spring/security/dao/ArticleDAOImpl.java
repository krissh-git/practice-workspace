package com.krishna.spring.security.dao;

import com.krishna.spring.security.entity.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ArticleDAOImpl implements IArticleDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Article> getAllArticles() {
        String query = "FROM Article as article ORDER BY article.articleId";
        return entityManager.createQuery(query, Article.class).getResultList();
    }

    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @Override
    public void addArticle(Article article) {
        entityManager.persist(article);
    }

    @Override
    public void updateArticle(Article article) {
        Article articleById = getArticleById(article.getArticleId());
        articleById.setTitle(article.getTitle());
        articleById.setCategory(article.getCategory());
        entityManager.flush();
    }

    @Override
    public void deleteArticle(int articleId) {
        entityManager.remove(getArticleById(articleId));
    }

    @Override
    public boolean articleExists(String title, String category) {
        String query = "FROM Article a WHERE a.title = ? AND a.category = ?";
        final int size = entityManager.createQuery(query)
                .setParameter(1, title).setParameter(2, category).getResultList().size();
        return size > 0;
    }
}
