package com.practicafinal.team.manager;

import com.practicafinal.team.model.Post;
import com.practicafinal.team.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostManager {
    @Autowired
    PostRepository postRepository;

    public List<Post> findAll(){ return postRepository.findAll(); }

    public Post savePost(Post thePost) {
        return postRepository.save(thePost);
    }

    public Optional<Post> getPlaneta(int theId) {
        return postRepository.findById(theId);
    }

    public void deletePlaneta(long theId) {
        postRepository.deleteById(theId);
    }
}
