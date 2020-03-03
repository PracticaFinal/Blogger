package com.practicafinal.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.practicafinal.entity.Post;
import com.practicafinal.entity.User;
import com.practicafinal.manager.PostManager;
import com.practicafinal.manager.TokenManager;
import com.practicafinal.manager.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
public class PostController {
    @Autowired
    PostManager postManager;

    @Autowired
    UserManager userManager;

    @Autowired
    TokenManager tokenManager;


    @Autowired
    Gson gson;
    @GetMapping("/listar")
    public List<Post> findAll(User user){
        return this.postManager.findAll(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody String jsonLogin) throws UnsupportedEncodingException {
        JsonObject jsonObject = gson.fromJson(jsonLogin,JsonObject.class);
        String user = jsonObject.get("user").getAsString();
        String pass = jsonObject.get("pass").getAsString();

        if(userManager.validUser(user,pass)){
            String token = tokenManager.createToken(user);
            System.out.println(userManager.validUser(user,pass));

            return new ResponseEntity<>(token, HttpStatus.OK);

        } else {
            System.out.println(userManager.validUser(user,pass));

            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }
}
