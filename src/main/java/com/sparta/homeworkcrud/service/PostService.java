package com.sparta.homeworkcrud.service;

import com.sparta.homeworkcrud.dto.PostDto;
import com.sparta.homeworkcrud.entity.Post;
import com.sparta.homeworkcrud.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postsRepository;
    public List<Post> getPosts() {
        return postsRepository.findAll();
    }

    @Transactional
    public Post createPost(PostDto postsDto) {
        Post posts = new Post(postsDto);
        postsRepository.save(posts);
        return posts;
    }

    public Post getPost(Long id) {

        return postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글 없음")
        );
    }

    @Transactional
    public Post updatePost(Long id, PostDto postDto) {
        Post post = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글 없음")
        );
        if(post.getPassword().equals(postDto.getPassword())) {
            post.update(postDto);
        }else {
            throw new IllegalArgumentException("비밀번호 불일치");
        }

        return post;
    }

    public String deletePost(Long id, String password) {

        Post post = postsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("게시글 없음")
        );

        if(post.getPassword().equals(password)) {
            postsRepository.deleteById(id);
            return "{\"result\":\"success\"}";
        }else {
            return "{\"result\":\"fail\"}";
        }

    }
}
