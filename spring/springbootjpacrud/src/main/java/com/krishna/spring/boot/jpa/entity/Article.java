package com.krishna.spring.boot.jpa.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articles")
public class Article implements Serializable {
    private static final long serialVersionUID = -3447971635055451364L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "article_id")
    private int articleId;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;

    public Article() {
    }

    public Article(int articleId, String title, String category) {
        this.articleId = articleId;
        this.title = title;
        this.category = category;
    }

    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
