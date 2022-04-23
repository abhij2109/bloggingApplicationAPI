package com.abhi.blogapplication.repositories;

import com.abhi.blogapplication.models.Category;
import com.abhi.blogapplication.models.Post;
import com.abhi.blogapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer>{

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
