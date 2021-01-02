package edu.arf4.motivationbalance.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan("edu.arf4.motivationbalance.rest")
@EnableWebMvc
@PropertySource("classpath:custom_app.properties")
public class WebConfig implements WebMvcConfigurer {

    @Value("${custom_app.origin}")
    public static String origin;


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(origin, "http://localhost:63342")
                .allowedMethods("GET", "POST", "DELETE");
    }

}
