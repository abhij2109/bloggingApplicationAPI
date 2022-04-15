package com.abhi.blogapplication.repositories;

import com.abhi.blogapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
