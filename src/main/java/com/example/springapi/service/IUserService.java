package com.example.springapi.service;

import com.example.springapi.api.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();

    Optional<User> getById(int id);

    void save(User user);

    void delete(int id);
}
