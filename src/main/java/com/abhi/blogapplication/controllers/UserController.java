package com.abhi.blogapplication.controllers;

import com.abhi.blogapplication.models.User;
import com.abhi.blogapplication.services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blogging/users")
public class UserController {

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User userDTO){
        User createdUser=userServiceImplementation.createUser(userDTO);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
