package com.abhi.blogapplication.services;


import com.abhi.blogapplication.exceptions.ResourceNotFoundException;
import com.abhi.blogapplication.models.User;
import com.abhi.blogapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImplementation {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return this.userRepository.save(user);
    }


    public User updateUser(User user, Integer userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        existingUser.setUserName(user.getUserName());
        existingUser.setUserEmail(user.getUserEmail());
        existingUser.setUserPassword(user.getUserPassword());
        return userRepository.save(existingUser);
    }


    public User getUserById(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        ArrayList<String> al=userRepository.findDetailsFromId(userId);
        String[] s =al.get(0).split(",");
        System.out.println(s[0]);
        System.out.println(s[1]);
        System.out.println(s[2]);
        return user;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    public void deleteUser(Integer userId) {
        User existingUser = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
        this.userRepository.delete(existingUser);
    }


}
