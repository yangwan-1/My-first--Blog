package com.athut.config;

import com.athut.intercepter.CommentIntercepter;
import com.athut.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yangwan
 * @create 2021-04-12 14:59
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginIntercepter())
                .addPathPatterns("/admin/**")//静态资源也会拦截
                .excludePathPatterns("/admin","/admin/login","/css/**","/fonts/**","/images/**","/js/**","/lib/**");
        registry.addInterceptor(new CommentIntercepter())
                .addPathPatterns("/comment/inputcomments/**")
                .excludePathPatterns("/comment","/css/**","/fonts/**","/images/**","/js/**","/lib/**");
    }
}
