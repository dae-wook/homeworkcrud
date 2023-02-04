package com.sparta.homeworkcrud.repository;

import com.sparta.homeworkcrud.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


}
