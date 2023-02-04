package com.sparta.homeworkcrud.controller;

import com.sparta.homeworkcrud.dto.PostDto;
import com.sparta.homeworkcrud.entity.Post;
import com.sparta.homeworkcrud.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostController {

    private final PostService postService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @PostMapping("/post")
    public Post createPosts(PostDto postsDto) {
        return postService.createPost(postsDto);
    }

    @GetMapping("/post/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PutMapping("/post/{id}")
    public Post updatePost(@PathVariable Long id, PostDto postDto) {
        return postService.updatePost(id, postDto);
    }

    @DeleteMapping("/post/{id}")
    public String deletePost(@PathVariable Long id, String password) {
        return postService.deletePost(id, password);
    }

}
