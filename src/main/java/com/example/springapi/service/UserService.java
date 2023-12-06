package com.example.springapi.service;

import com.example.springapi.api.model.User;
import com.example.springapi.dto.UserDTO;
import com.example.springapi.repository.UserDAO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ModelMapper modelMapper;


    @Transactional
    public UserDTO getById(int id) {
        User user = userDAO.getById(id);
        if(user == null)
        {
            return  null;
        }

        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
        return userDTO;
    }

    @Transactional
    public List<UserDTO> getAll() {

        List<User> users = userDAO.getAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for(User user : users)
        {
            UserDTO userDTO = modelMapper.map(user, UserDTO.class);
            userDTOs.add(userDTO);
        }

        return userDTOs;

    }


    @Transactional
    public void create(User user) {
        user.setPassword(toHash(user.getPassword()));
        userDAO.save(user);
    }

    @Transactional
    public User update(User user) {
        user.setPassword(toHash(user.getPassword()));
        return userDAO.update(user);
    }

    @Transactional
    @Override
    public void delete(int id) {
        userDAO.delete(id);
    }

    public String toHash(String stringToHash)
    {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA256");
            md.update(stringToHash.getBytes());
            byte[] result = md.digest();
            StringBuilder sb = new StringBuilder();
            for(byte b : result)
            {
                sb.append(String.format("%02x",b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e)
        {
            return "No such algo";
        }

    }
}
