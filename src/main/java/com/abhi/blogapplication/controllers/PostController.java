package com.abhi.blogapplication.controllers;

import com.abhi.blogapplication.dto.ApiResponse;
import com.abhi.blogapplication.dto.PostDTO;
import com.abhi.blogapplication.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogging/")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/user/{userId}/category/{categoryId}/post/")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId)
    {
        PostDTO createdPost=postService.createPost(postDTO,userId,categoryId);
        return new ResponseEntity<PostDTO>(createdPost, HttpStatus.CREATED);
    }

    @PutMapping("user/{userId}/category/{categoryId}/post/{postId}/")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO,
                                              @PathVariable Integer userId,
                                              @PathVariable Integer categoryId,
                                              @PathVariable Integer postId)
    {
        PostDTO updatedPost=postService.updatePost(postDTO,userId,categoryId,postId);
        return new ResponseEntity<PostDTO>(updatedPost,HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Integer userId){
        List<PostDTO> allPosts=postService.getPostsByUser(userId);
        return new ResponseEntity<List<PostDTO>>(allPosts,HttpStatus.OK);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Integer categoryId){
        List<PostDTO> allPosts=postService.getPostsByCategory(categoryId);
        return new ResponseEntity<List<PostDTO>>(allPosts,HttpStatus.OK);
    }

    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts()
    {
        List<PostDTO> allPost = postService.getAllPost();
        return new ResponseEntity<List<PostDTO>>(allPost,HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Integer postId)
    {
        PostDTO postDTO=postService.getPostById(postId);
        return new ResponseEntity<PostDTO>(postDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/posts/{postId}")
    public ApiResponse deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        return new ApiResponse("Post successfully deleted.!!",true);
    }
}
