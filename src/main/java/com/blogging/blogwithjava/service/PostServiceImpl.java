package com.blogging.blogwithjava.service;

import com.blogging.blogwithjava.entity.Post;
import com.blogging.blogwithjava.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {


    @Autowired
    private PostRepository postRepository;

    public Post savePost(Post post) {
        return postRepository.save(post);
    }
}
