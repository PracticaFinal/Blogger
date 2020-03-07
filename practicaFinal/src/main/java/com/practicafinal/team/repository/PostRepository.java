package com.practicafinal.team.repository;


import com.practicafinal.team.model.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAll();

    @Override
    Optional<Post> findById(Integer integer);

    @Override
    void deleteById(Integer integer);

    @Override
    <S extends Post> S save(S s);
}
