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
    public Optional<User> getById(int id) {
        Optional toReturn = Optional.empty();

        return toReturn;
    }

    @Transactional
    public List<User> getAll() {
        return userDAO.getAll();
    }

    @Transactional
    @Override
    public void save(User user) {

    }

    @Transactional
    @Override
    public void delete(int id) {

    }
}
