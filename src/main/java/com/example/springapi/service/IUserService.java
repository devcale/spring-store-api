package com.example.springapi.service;

import com.example.springapi.api.model.User;
import com.example.springapi.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UserDTO> getAll();

    UserDTO getById(int id);

    void create(User user);

    User update(User user);

    void delete(int id);
}
