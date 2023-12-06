package com.example.springapi.repository;

import com.example.springapi.api.model.User;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO implements IUserDAO{

    @Autowired
    private EntityManager entityManager;


    public List<User> getAll() {
       Session currentSession = entityManager.unwrap(Session.class);
       Query<User> query = currentSession.createQuery("FROM User", User.class);
       List<User> list = query.getResultList();
       return list;
    }

    public User getById(int id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(int id) {

    }
}
