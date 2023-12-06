package com.example.springapi.service;

import com.example.springapi.api.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();

    User getById(int id);

    void create(User user);

    User update(User user);

    void delete(int id);
}
