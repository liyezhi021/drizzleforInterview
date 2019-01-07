package com.example.aopIntercepterFilter.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new BookFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.setName("BookFilter~");
        registrationBean.setOrder(1);
        return registrationBean;
    }

}
