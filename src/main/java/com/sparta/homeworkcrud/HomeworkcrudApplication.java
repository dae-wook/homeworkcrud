package com.sparta.homeworkcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HomeworkcrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(HomeworkcrudApplication.class, args);
    }

}
