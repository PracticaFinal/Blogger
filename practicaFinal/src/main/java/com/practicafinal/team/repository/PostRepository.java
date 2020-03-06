package com.practicafinal.team.repository;


import com.practicafinal.team.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAllByTitleOrAndContent(String query, String query2);
}
