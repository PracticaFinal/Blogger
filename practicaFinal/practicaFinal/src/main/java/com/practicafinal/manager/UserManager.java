package com.practicafinal.manager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.practicafinal.entity.User;
import com.practicafinal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
    @Autowired
    UserRepository userRepository;

    @Autowired
    Gson gson;

    public boolean validUser(String email, String name){
        System.out.println(userRepository.findByEmailAndName(email,name));
        return (userRepository.findByEmailAndName(email,name)) != null;
    }

    public User jsonToUser(String json){
        JsonObject jsonObject = gson.fromJson(json,JsonObject.class);
        String user = jsonObject.get("email").getAsString();
        String name = jsonObject.get("name").getAsString();
        return null;
    }
}
