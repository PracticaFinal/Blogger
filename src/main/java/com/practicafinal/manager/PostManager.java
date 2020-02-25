package com.practicafinal.manager;


import com.practicafinal.entity.Post;
import com.practicafinal.entity.User;
import com.practicafinal.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostManager {

    @Autowired
    PostRepository postRepository;

    public void add(Post post){
        postRepository.save(post);
    }

    public List<Post> findAll(User user){
        return postRepository.findAllByUser(user);
    }
}
