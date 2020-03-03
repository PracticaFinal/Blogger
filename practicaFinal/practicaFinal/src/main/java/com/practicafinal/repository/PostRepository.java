package com.practicafinal.repository;

import com.practicafinal.entity.Post;
import com.practicafinal.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post,Long> {
    List<Post> findAllByUser(User user);
}
