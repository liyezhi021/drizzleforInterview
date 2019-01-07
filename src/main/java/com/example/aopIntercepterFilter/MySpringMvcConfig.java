package com.example.aopIntercepterFilter;

import com.example.aopIntercepterFilter.Intercepter.BookConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class MySpringMvcConfig implements WebMvcConfigurer {

    @Autowired
    private BookConfig config;

    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(config).addPathPatterns("/**");
    }

}
