package com.poc.springangular2hibernatemysql.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "articles")
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int articleId;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;


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
