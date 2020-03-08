package com.practicafinal.team.repository;


import com.practicafinal.team.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Transactional
public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findAll();

    @Override
    Optional<Post> findById(Integer integer);

    void deleteById(long theId);

    @Override
    <S extends Post> S save(S s);
}
