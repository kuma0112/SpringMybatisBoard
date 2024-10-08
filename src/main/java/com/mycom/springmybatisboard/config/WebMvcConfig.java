package com.mycom.springmybatisboard.config;

import com.mycom.springmybatisboard.common.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptor)
//                .addPathPatterns("/**")
//                .excludePathPatterns("/pages/login",
//                "/",
//                "index.html",
//                "pages/user");
//    }

                registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/pages/board/**");
    }


}
