package com.practicafinal.manager;


import com.practicafinal.entity.Post;
import com.practicafinal.entity.User;
import com.practicafinal.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PostManager {

    @Autowired
    PostRepository postRepository;

    public static <T> List<T> toList(final Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false)
                .collect(Collectors.toList());
    }
    public List<Post> findAll(User user){
        //return postRepository.findAllByUser(user);

        return PostManager.toList(postRepository.findAll());
    }
}
