package com.krishna.spring.boot.jpa.dao;

import com.krishna.spring.boot.jpa.ArticleRowMapper;
import com.krishna.spring.boot.jpa.entity.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ArticleDAOImpl implements ArticleDAO {

    private JdbcTemplate jdbcTemplate;

    private final String GET_ALL_QUERY = "SELECT * from articles";
    private final String GET_BY_ID_QUERY = "SELECT * from articles where article_id = ?";
    private final String ADD_QUERY = "insert into articles (title,category) values (?,?)";
    private final String UPDATE_QUERY = "update articles set title = ?, category=? where article_id = ?";
    private final String DELETE_QUERY = "delete from articles where article_id = ?";

    public ArticleDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Article> getAllArticles() {
        System.out.println("JDBC getAllArticles");
        return jdbcTemplate.query(GET_ALL_QUERY, new ArticleRowMapper());
    }

    @Override
    public Article getArticleById(int articleId) {
        System.out.println("JDBC getArticleById"+articleId);
        return jdbcTemplate.queryForObject(GET_BY_ID_QUERY, new Object[]{articleId},new ArticleRowMapper());
    }

    @Override
    public Article addArticle(Article article) {
        System.out.println("JDBC addArticle"+article);

        final int update = jdbcTemplate.update(ADD_QUERY, article.getTitle(), article.getCategory());
        return article;
    }

    @Override
    public Article updateArticle(Article article) {
        System.out.println("JDBC updateArticle"+article);

        final int update = jdbcTemplate.update(UPDATE_QUERY, article.getTitle(), article.getCategory(), article.getArticleId());
        return article;
    }

    @Override
    public void deleteArticle(int articleId) {
        System.out.println("JDBC deleteArticle"+articleId);

        final int update = jdbcTemplate.update(DELETE_QUERY, articleId);

    }
}
