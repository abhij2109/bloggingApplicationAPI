package com.abhi.blogapplication.services;

import com.abhi.blogapplication.dto.PostDTO;
import com.abhi.blogapplication.dto.PostResponse;
import com.abhi.blogapplication.models.Post;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO dto, Integer userId, Integer catId);

    PostDTO updatePost(PostDTO dto, Integer userId, Integer catId, Integer postId);

    PostDTO getPostById(Integer id);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize);

    void deletePost(Integer postId);

    List<PostDTO> getPostsByCategory(Integer categoryId);

    List<PostDTO> getPostsByUser(Integer userId);

    List<Post> searchPosts(String keyword);

}
