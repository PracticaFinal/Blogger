package com.practicafinal.configuration;

import com.practicafinal.handlers.TokenInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class InterceptorConfig implements WebMvcConfigurer {

    @Bean
    public TokenInterceptor getInterceptor(){
        return new TokenInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(getInterceptor()).addPathPatterns("").excludePathPatterns("/login");
    }
}
