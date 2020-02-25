package com.practicafinal.repository;

import com.practicafinal.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByEmailAndName(String email, String name);
}
