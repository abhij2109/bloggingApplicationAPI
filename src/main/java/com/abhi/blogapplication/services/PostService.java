package com.abhi.blogapplication.services;

import com.abhi.blogapplication.dto.PostDTO;
import com.abhi.blogapplication.models.Post;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO dto, Integer userId, Integer catId);

    PostDTO updatePost(PostDTO dto,Integer id);

    Post getPostById(Integer id);

    List<Post> getAllPost();

    void deletePost(Integer id);

    List<Post> getPostsByCategory(Integer categoryId);

    List<Post> getPostsByUser(Integer userId);

    List<Post> searchPosts(String keyword);

}
