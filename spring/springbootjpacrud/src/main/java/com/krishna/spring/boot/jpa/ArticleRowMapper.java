package com.krishna.spring.boot.jpa;

import com.krishna.spring.boot.jpa.entity.Article;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ArticleRowMapper implements RowMapper<Article> {
    @Override
    public Article mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Article(resultSet.getInt("article_id"),resultSet.getString("title"),resultSet.getString("category"));
    }
}
