package org.glebindustries.veterinary_application.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CognitoWebConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/menu").setViewName("menu");
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/user").setViewName("user");
        registry.addViewController("/test").setViewName("test");
    }
}
