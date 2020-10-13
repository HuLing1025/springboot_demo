package com.example.demo;

import com.example.demo.utils.JwtInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorsConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JwtInterceptors())
                .addPathPatterns("/springboot/user/**")
                .excludePathPatterns("/springboot/user/login")
                .excludePathPatterns("/springboot/user/logon")
                .excludePathPatterns("/springboot/user/test")
                .excludePathPatterns("/springboot/user/testlogin")
                .excludePathPatterns("/springboot/user/testlogon");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/")
                .addResourceLocations("/resources/**");
    }
}
