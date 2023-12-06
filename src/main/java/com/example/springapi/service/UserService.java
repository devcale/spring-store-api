package com.example.springapi.service;

import com.example.springapi.api.model.User;
import com.example.springapi.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserDAO userDAO;



    @Transactional
    public User getById(int id) {
        return userDAO.getById(id);
    }

    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }


    @Transactional
    public void create(User user) {
        userDAO.save(user);
    }

    @Transactional
    public User update(User user) {
        return userDAO.update(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }
}
