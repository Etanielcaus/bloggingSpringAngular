package com.blogging.blogwithjava.controller;

import com.blogging.blogwithjava.entity.Post;
import com.blogging.blogwithjava.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "*")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post){
        System.out.println("Received Post Name: " + post.getName());
        System.out.println("Received Post Content: " + post.getContent());
        System.out.println("Received Post Img: " + post.getImg());

        try {
            Post createdPost = postService.savePost(post);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping
    public ResponseEntity<?> findAllPosts(){
        List<Post> all = postService.getAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(all);
    }

    @GetMapping(
            value = "/{id}"
    )
    public ResponseEntity<?> findById(@PathVariable(value = "id") Long id){
        Post postById = postService.findPostById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(postById);
    }


}
