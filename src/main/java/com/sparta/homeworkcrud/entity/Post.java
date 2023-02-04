package com.sparta.homeworkcrud.entity;

import com.sparta.homeworkcrud.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Post extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String contents;

    public Post(PostDto postsDto) {
        this.title = postsDto.getTitle();
        this.author = postsDto.getAuthor();
        this.password = postsDto.getPassword();
        this.contents = postsDto.getContents();
    }

    public void update(PostDto postDto) {
        this.title = postDto.getTitle();
        this.contents = postDto.getContents();
    }

}
