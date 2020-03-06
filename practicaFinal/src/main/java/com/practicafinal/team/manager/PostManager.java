package com.practicafinal.team.manager;

import com.practicafinal.team.model.Post;
import com.practicafinal.team.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostManager {
    @Autowired
    PostRepository postRepository;

    public List<Post> findAllBytitleOrContent(String query){ return postRepository.findAllByTitleOrAndContent(query, query); }
}
