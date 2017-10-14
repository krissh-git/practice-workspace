package com.poc.springangular2hibernatemysql.dao;

import com.poc.springangular2hibernatemysql.model.Article;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ArticleDaoImpl implements ArticleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void createArticle(Article article) {
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
        Article articleById = getArticleById(articleId);
        entityManager.remove(articleById);
    }

    @Override
    public Article getArticleById(int articleId) {
        return entityManager.find(Article.class, articleId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Article> getArticles() {
        final String hql = "FROM Article art ORDER BY art.articleId DESC";
        return (List<Article>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public boolean articleExists(String title, String category) {
        final String hql = "FROM Article as art " +
                "WHERE art.title = ? " +
                "AND art.category = ?";
        int size = entityManager.createQuery(hql)
                .setParameter(1, title)
                .setParameter(2, category).getResultList().size();
        return size > 0;
    }
}
