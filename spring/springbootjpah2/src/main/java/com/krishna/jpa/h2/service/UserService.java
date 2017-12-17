package com.krishna.jpa.h2.service;

import com.krishna.jpa.h2.entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class UserService {

    @PersistenceContext
    private EntityManager entityManager;

    public UserService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Long addUser(User user) {
        entityManager.persist(user);
        return user.getId();
    }


    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }


    public List<User> getUsers() {
        return entityManager.createNamedQuery("GET_ALL_USERS", User.class).getResultList();
    }


}
