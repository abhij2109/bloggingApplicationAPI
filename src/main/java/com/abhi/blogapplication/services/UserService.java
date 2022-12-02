package com.abhi.blogapplication.services;

import com.abhi.blogapplication.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO registerUser(UserDTO user);

    UserDTO createUser(UserDTO user);

    UserDTO updateUser(UserDTO user, Integer userId);

    UserDTO getUserById(Integer userId);

    List<UserDTO> getAllUsers();

    void deleteUser(Integer userId);
}
