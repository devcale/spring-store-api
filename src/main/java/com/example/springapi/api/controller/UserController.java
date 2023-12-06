package com.example.springapi.api.controller;

import com.example.springapi.api.model.User;
import com.example.springapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id)
    {
        Optional user =  userService.getById(id);
        if(user.isPresent())
        {
            return ResponseEntity.ok((User) user.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers()
    {
        return ResponseEntity.ok(userService.getAll());
    }
}
