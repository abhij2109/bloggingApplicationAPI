package com.abhi.blogapplication.services.implementation;

import com.abhi.blogapplication.dto.UserDTO;
import com.abhi.blogapplication.exceptions.ResourceNotFoundException;
import com.abhi.blogapplication.models.User;
import com.abhi.blogapplication.repositories.UserRepository;
import com.abhi.blogapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);
        User savedUser = this.userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "Id", userId)
                );
        existingUser.setUserName(userDTO.getUserName());
        existingUser.setUserEmail(userDTO.getUserEmail());
        existingUser.setUserPassword(userDTO.getUserPassword());
        User savedUser = userRepository.save(existingUser);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "Id", userId)
                );
        return this.userToDto(existingUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        List<UserDTO> all = new ArrayList<>();
        for (User existing : allUsers) {
            all.add(this.userToDto(existing));
        }
        return all;
    }

    @Override
    public void deleteUser(Integer userId) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "Id", userId)
                );
        this.userRepository.delete(existingUser);
    }

    private User dtoToUser(UserDTO userDTO) {
        return this.modelMapper.map(userDTO,User.class);
    }

    private UserDTO userToDto(User user) {
        return this.modelMapper.map(user,UserDTO.class);
    }
}
