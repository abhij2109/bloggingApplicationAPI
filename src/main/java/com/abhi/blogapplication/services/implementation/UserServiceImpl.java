package com.abhi.blogapplication.services.implementation;

import com.abhi.blogapplication.dto.UserDTO;
import com.abhi.blogapplication.exceptions.ResourceNotFoundException;
import com.abhi.blogapplication.models.Role;
import com.abhi.blogapplication.models.User;
import com.abhi.blogapplication.repositories.RoleRepository;
import com.abhi.blogapplication.repositories.UserRepository;
import com.abhi.blogapplication.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user=modelMapper.map(userDTO, User.class);
        //encoded the password.
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        // roles
        Role role=roleRepository.findById(502).get();
        user.getRoles().add(role);
        User newUser=userRepository.save(user);
        return modelMapper.map(newUser, UserDTO.class);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);
        user.setUserCreated(new Date());
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
        List<UserDTO> getUsers = allUsers
                                .stream()
                                .map(this::userToDto)
                                .collect(Collectors.toList());
        return getUsers;
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
        return this.modelMapper.map(userDTO, User.class);
    }

    private UserDTO userToDto(User user) {
        return this.modelMapper.map(user, UserDTO.class);
    }
}
