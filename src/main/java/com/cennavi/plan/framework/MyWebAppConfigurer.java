package com.cennavi.plan.framework;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * 拦截器
 */

//@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {
    @Resource
    UserLoginInterceptor userLoginInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLoginInterceptor)
                .excludePathPatterns("/user/login", "/user/toLoginPage", "/user/logout", "/user/error/unlogin")
                .addPathPatterns("/**");
    }
}
