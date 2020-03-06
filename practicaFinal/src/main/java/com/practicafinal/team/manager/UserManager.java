package com.practicafinal.team.manager;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.practicafinal.team.model.User;
import com.practicafinal.team.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Gson gson;

    public boolean validUser(String email, String pass){
        return (userRepository.findByEmailAndPassword(email,pass) != null);
    }

    public User jsonToUser(String json){
        JsonObject jsonObject = gson.fromJson(json,JsonObject.class);
        String user = jsonObject.get("user").getAsString();
        String pass = jsonObject.get("pass").getAsString();
        return null;
    }
}