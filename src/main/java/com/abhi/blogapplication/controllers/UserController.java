package com.abhi.blogapplication.controllers;

import com.abhi.blogapplication.models.User;
import com.abhi.blogapplication.services.UserServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogging/users")
public class UserController {

    @Autowired
    private UserServiceImplementation userServiceImplementation;

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User createdUser=userServiceImplementation.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") Integer id){
        User updatedUser=userServiceImplementation.updateUser(user,id);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getSingleUser(@PathVariable("id") Integer id){
        User user=userServiceImplementation.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User>  allUsers=userServiceImplementation.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Integer id){
        userServiceImplementation.deleteUser(id);
    }
}
