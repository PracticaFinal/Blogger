package com.practicafinal.manager;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.TextCodec;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenManager {
    public static final String SECRETO = "Secretin secretado, este Secreto esta Encriptado";
    public String createToken(String user){
        String token = Jwts.builder().claim("username",user)
                .setExpiration(new Date(System.currentTimeMillis() + 3600))
                .signWith(SignatureAlgorithm.HS256, TextCodec.BASE64.encode(SECRETO)).compact();
           return token;
    }

    public boolean validateToken(String token){
        try{
            Claims claims = Jwts.parser().setSigningKey(SECRETO.getBytes()).parseClaimsJws(token).getBody();

            return claims != null;
        } catch (Exception e){
            return false;
        }
    }
}
