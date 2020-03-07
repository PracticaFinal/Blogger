package com.practicafinal.team.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.practicafinal.team.manager.PostManager;
import com.practicafinal.team.manager.TokenManager;
import com.practicafinal.team.manager.UserManager;
import com.practicafinal.team.model.Post;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/buscar") //GET MAPPING PORQUE EL METHOD ES 'GET', Y LO MISMO CON EL POST, PORQUE ES POST
    public List<Post> findByTitleOrContent(String buscar){
        String s = buscar;
        System.out.println(this.postManager.findAllBytitleOrContent(s));
        return this.postManager.findAllBytitleOrContent(s);
    }

    @PostMapping("/login")
    public ResponseEntity<String> validateUser(@RequestBody String jsonLogin) throws  JSONException {
        JSONObject jsonObject = new JSONObject(jsonLogin);
        JSONObject body = jsonObject.getJSONObject("body");

        String user = body.getString("user");
        String pass = body.getString("pass");

        if(userManager.validUser(user,pass)){
            String token = tokenManager.createToken(user);
            System.out.println(userManager.validUser(user,pass));

            return new ResponseEntity<>(token,HttpStatus.OK);

        } else {
            System.out.println(userManager.validUser(user,pass));

            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

    }
}