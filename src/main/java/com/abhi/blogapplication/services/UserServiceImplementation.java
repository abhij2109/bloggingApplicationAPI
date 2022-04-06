package com.abhi.blogapplication.services;


import com.abhi.blogapplication.exceptions.ResourceNotFoundException;
import com.abhi.blogapplication.models.User;
import com.abhi.blogapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        User savedUser = this.userRepository.save(user);
        return savedUser;
    }


    public User updateUser(User user, Integer userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        existingUser.setUserPassword(user.getUserPassword());
        User saveUser = userRepository.save(existingUser);
        return saveUser;
    }


    public User getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        return user;
    }


    public List<User> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

    public void deleteUser(Integer userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepository.delete(existingUser);
    }


}
