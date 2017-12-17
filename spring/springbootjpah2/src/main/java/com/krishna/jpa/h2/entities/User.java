package com.krishna.jpa.h2.entities;

import javax.persistence.*;


@Entity
@Table(name = "user")
@NamedQuery(name = "GET_ALL_USERS",query = "SELECT u FROM User u")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String role;


    protected User() {
    }

    public User(String name, String role) {
        this.name = name;
        this.role = role;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
