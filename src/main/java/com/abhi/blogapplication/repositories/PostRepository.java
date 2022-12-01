package com.abhi.blogapplication.repositories;

import com.abhi.blogapplication.models.Category;
import com.abhi.blogapplication.models.Post;
import com.abhi.blogapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}
