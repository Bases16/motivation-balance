package edu.arf4.motivationbalance.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("edu.arf4.motivationbalance.controller")
@EnableWebMvc
@PropertySource("classpath:custom_app.properties")
public class WebConfig implements WebMvcConfigurer {}
