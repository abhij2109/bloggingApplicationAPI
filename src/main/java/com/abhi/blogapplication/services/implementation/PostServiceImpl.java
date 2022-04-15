package com.abhi.blogapplication.services.implementation;

import com.abhi.blogapplication.dto.PostDTO;
import com.abhi.blogapplication.exceptions.ResourceNotFoundException;
import com.abhi.blogapplication.models.Category;
import com.abhi.blogapplication.models.Post;
import com.abhi.blogapplication.models.User;
import com.abhi.blogapplication.repositories.CategoryRepository;
import com.abhi.blogapplication.repositories.PostRepository;
import com.abhi.blogapplication.repositories.UserRepository;
import com.abhi.blogapplication.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDTO createPost(PostDTO dto, Integer userId, Integer catId) {

        User user=userRepository.findById(userId)
                .orElseThrow(
                    ()->new ResourceNotFoundException("User","id",userId)
        );
        Category cat=categoryRepository.findById(catId)
                .orElseThrow(
                        ()->new ResourceNotFoundException("User","id",userId)
                );
        Post post=this.modelMapper.map(dto,Post.class);
        post.setImageName("default.png");
        post.setCreatedDate(new Date());
        post.setUser(user);
        post.setCategory(cat);
        Post createdPost=postRepository.save(post);
        return this.modelMapper.map(createdPost,PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO dto, Integer id) {
        return null;
    }

    @Override
    public Post getPostById(Integer id) {
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public void deletePost(Integer id) {

    }

    @Override
    public List<Post> getPostsByCategory(Integer categoryId) {
        return null;
    }

    @Override
    public List<Post> getPostsByUser(Integer userId) {
        return null;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
