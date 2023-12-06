package com.example.springapi.api.controller;

import com.example.springapi.api.model.User;
import com.example.springapi.dto.UserDTO;
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
    public ResponseEntity<UserDTO> getUserById(@PathVariable Integer id)
    {
        UserDTO user =  userService.getById(id);
        if(user != null)
        {
            return ResponseEntity.ok((UserDTO) user);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserDTO>> getUsers()
    {
        return ResponseEntity.ok(userService.getAll());
    }

    @PostMapping("/user")
    public ResponseEntity<String> createUser(@RequestBody User userObj)
    {
        try{
            userService.create(userObj);
            return new ResponseEntity<>("User created:" + userObj, HttpStatus.CREATED);
        } catch (Exception e)
        {
            return new ResponseEntity<>("An error occurred when creating the User:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/user")
    public ResponseEntity<String> updateUser(@RequestBody User userObj)
    {
        try{
            User updatedUser = userService.update(userObj);
            return new ResponseEntity<>("User updated:" + updatedUser, HttpStatus.OK);
        } catch (Exception e)
        {
            return new ResponseEntity<>("An error occurred when creating the User:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id)
    {
        try{
            userService.delete(id);
            return new ResponseEntity<>("User of id "+id+" successfully deleted.", HttpStatus.NO_CONTENT);
        } catch (Exception e)
        {
            return new ResponseEntity<>("An error occurred when deleting the User:" + e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
