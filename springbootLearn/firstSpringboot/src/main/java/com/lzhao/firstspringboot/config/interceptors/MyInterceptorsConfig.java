package com.lzhao.firstspringboot.config.interceptors;

import com.lzhao.firstspringboot.components.interceptors.MyInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
class MyInterceptorsConfig implements WebMvcConfigurer {

    @Resource(name = "MyInterceptors")
    private MyInterceptors myInterceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptors);
    }
}
