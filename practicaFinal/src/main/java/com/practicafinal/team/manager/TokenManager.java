package com.practicafinal.team.manager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenManager {
    private static final String SECRETO = "EL SECRETO QUE ME SALE DE LA P***";

    public String createToken(String user){
        String token = Jwts.builder().claim("username",user)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) //eso es una hora
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(SECRETO)).compact();
        return token;
    }

    public boolean validateToken(String token){
        try{
            Claims claims =Jwts.parser()
                    .setSigningKey(SECRETO.getBytes())
                    .parseClaimsJws(token).getBody();

            return claims != null;

        } catch (Exception e){
            return false;
        }
    }
}