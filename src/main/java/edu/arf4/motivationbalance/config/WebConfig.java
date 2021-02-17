package edu.arf4.motivationbalance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("edu.arf4.motivationbalance.controller")
@EnableWebMvc
@PropertySource("classpath:custom_app.properties")
public class WebConfig implements WebMvcConfigurer {

    private final ApplicationContext applicationContext;
    @Value("${frontendAppOrigin}")
    private String frontendAppOrigin;

    public WebConfig(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins(frontendAppOrigin)
//                .allowedMethods("GET", "POST")
//                .allowedHeaders("Authorization");

        registry.addMapping("/rest/auth/login")
                .allowedOrigins(frontendAppOrigin)
                .allowedMethods("POST");

        registry.addMapping("/rest/auth/register")
                .allowedOrigins(frontendAppOrigin)
                .allowedMethods("POST");

        registry.addMapping("/rest/results/*")
                .allowedOrigins(frontendAppOrigin)
                .allowedMethods("GET")
                .allowedHeaders("Authorization");

        registry.addMapping("/rest/factors")
                .allowedOrigins(frontendAppOrigin)
                .allowedMethods("GET")
                .allowedHeaders("Authorization");
    }

}
