package com.example.springapi.repository;

import com.example.springapi.api.model.User;

import java.util.List;

public interface IUserDAO {

    List<User> getAll();

    User getById(int id);

    void save(User user);

    User update(User user);

    void delete(int id);
}
