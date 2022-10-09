package com.abhi.blogapplication.services.implementation;

import com.abhi.blogapplication.dto.PostDTO;
import com.abhi.blogapplication.dto.PostResponse;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", userId)
                );
        Category cat = categoryRepository.findById(catId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Category", "id", catId)
                );
        Post post = this.modelMapper.map(dto, Post.class);
        post.setImageName("default.png");
        post.setCreatedDate(new Date());
        post.setUser(user);
        post.setCategory(cat);
        Post createdPost = postRepository.save(post);
        return this.modelMapper.map(createdPost, PostDTO.class);
    }


    @Override
    public PostDTO updatePost(PostDTO dto, Integer userId, Integer catId, Integer postId) {
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", userId)
                );
        Category cat = categoryRepository.findById(catId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Category", "id", userId)
                );
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "id", postId)
                );
        Post existingPost = this.modelMapper.map(dto, Post.class);
        existingPost.setImageName("default.png");
        existingPost.setContent(dto.getContent());
        existingPost.setCreatedDate(new Date());
        existingPost.setCategory(cat);
        existingPost.setUser(user);

        Post updatedPost = postRepository.save(existingPost);
        return this.modelMapper.map(updatedPost, PostDTO.class);
    }


    @Override
    public PostDTO getPostById(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "id", postId)
                );

        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
        return postDTO;
    }


    @Override
    public PostResponse getAllPost(Integer pageNumber, Integer pageSize) {

        Pageable p= PageRequest.of(pageNumber,pageSize);

        Page<Post> pagePost = postRepository.findAll(p);
        List<Post> allPosts =pagePost.getContent();

        List<PostDTO> postsDTO = allPosts
                .stream()
                .map(
                        (post) -> modelMapper.map(post, PostDTO.class)
                ).collect(Collectors.toList());

        PostResponse postResponse=new PostResponse();
        postResponse.setContent(postsDTO);
        postResponse.setPageNumber(pagePost.getNumber());
        postResponse.setPageSize(pagePost.getSize());
        postResponse.setTotalElements(pagePost.getNumberOfElements());
        postResponse.setTotalPages(pagePost.getTotalPages());
        postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }


    @Override
    public void deletePost(Integer postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Post", "id", postId)
                );
        postRepository.delete(post);
    }


    @Override
    public List<PostDTO> getPostsByCategory(Integer categoryId) {

        Category cat = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", categoryId)
        );
        List<Post> postsByCategory = postRepository.findByCategory(cat);
        List<PostDTO> allPostsByCategory = postsByCategory.stream()
                .map(
                        (post) -> modelMapper.map(post, PostDTO.class)
                ).collect(Collectors.toList());
        return allPostsByCategory;
    }


    @Override
    public List<PostDTO> getPostsByUser(Integer userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new ResourceNotFoundException("User", "id", userId)
                );
        List<Post> postsByUser = postRepository.findByUser(user);
        List<PostDTO> allPostsByUser = postsByUser
                .stream()
                .map(
                        (post) -> modelMapper.map(post, PostDTO.class)
                ).collect(Collectors.toList());
        return allPostsByUser;
    }


    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
