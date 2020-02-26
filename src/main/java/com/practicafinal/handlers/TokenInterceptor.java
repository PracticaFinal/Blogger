package com.practicafinal.handlers;

import com.practicafinal.manager.TokenManager;
import io.jsonwebtoken.JwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor {
    @Autowired
    TokenManager tokenManager;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        try {
            System.out.println("prehandler :)");
            String auth = request.getHeader("Authorization");
            System.out.println(auth);

            if (auth != null && !auth.isEmpty()) {
                String token = auth.replace("Bearer ", "");
                boolean valido =  tokenManager.validateToken(token);

                if(!valido){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    return false;
                } else {
                    response.setStatus(HttpServletResponse.SC_OK);
                }
            }
            return true;
        } catch (JwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
        }
        return false;
    }
}
