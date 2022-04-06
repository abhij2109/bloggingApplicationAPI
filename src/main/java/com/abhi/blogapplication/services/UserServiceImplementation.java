package com.abhi.blogapplication.services;

import com.abhi.blogapplication.dto.UserDTO;
import com.abhi.blogapplication.models.User;
import com.abhi.blogapplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImplementation {

    @Autowired
    private UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        User user=this.dtoToUser(userDTO);
        User savedUser=this.userRepository.save(user);
        return this.userToDto(savedUser);
    }


    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User user=this.dtoToUser(userDTO);
        User existingUser=userRepository.getById(userId);
        existingUser.setUserName("XYZ");
        existingUser.setUserEmail("xyz@gmail.com");
        existingUser.setUserPassword("abc@21");
        User saveUser=userRepository.save(existingUser);
        return this.userToDto(saveUser);
    }


    public UserDTO getUserById(Integer userId) {
        User user=userRepository.getById(userId);
        return this.userToDto(user);
    }


    public List<UserDTO> getAllUsers() {
        List<User> allUsers=userRepository.findAll();
        ArrayList<UserDTO> all=new ArrayList<>();
        for(User existing:allUsers)
        {
            all.add(this.userToDto(existing));
        }
        return all;
    }

    public void deleteUser(Integer userId) {
        this.userRepository.deleteById(userId);
    }

    private User dtoToUser(UserDTO userDTO){
        User user=new User();
        user.setId(userDTO.getId());
        user.setUserName(userDTO.getUserName());
        user.setUserEmail(userDTO.getUserEmail());
        user.setUserPassword(userDTO.getUserPassword());
        user.setAbout(userDTO.getAbout());
        user.setUserCreated(userDTO.getUserCreated());
        return user;
    }

    private UserDTO userToDto(User user){
        UserDTO userDTO=new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserName(user.getUserName());
        userDTO.setUserEmail(user.getUserEmail());
        userDTO.setUserPassword(user.getUserPassword());
        userDTO.setAbout(user.getAbout());
        userDTO.setUserCreated(user.getUserCreated());
        return userDTO;
    }
}
