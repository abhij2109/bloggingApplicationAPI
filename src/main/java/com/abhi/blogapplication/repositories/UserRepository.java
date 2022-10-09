package com.abhi.blogapplication.repositories;

import com.abhi.blogapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUserEmail(String userEmail);

}
