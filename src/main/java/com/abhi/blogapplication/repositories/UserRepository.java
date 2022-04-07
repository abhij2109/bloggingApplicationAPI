package com.abhi.blogapplication.repositories;

import com.abhi.blogapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "Select user_name,user_email,user_password from users where id=?1",nativeQuery = true)
    ArrayList<String> findDetailsFromId(Integer id);
}
