package com.practicafinal.team.repository;


import com.practicafinal.team.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmailAndPassword(String email,String pass);
}
