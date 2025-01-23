package com.blogging.blogwithjava.service;

import com.blogging.blogwithjava.entity.Post;

import java.util.List;

public interface PostService {

     Post savePost(Post post);

     List<Post> getAll();

     Post findPostById(Long id);

}
