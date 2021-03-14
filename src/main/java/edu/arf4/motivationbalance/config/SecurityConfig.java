package edu.arf4.motivationbalance.config;

import edu.arf4.motivationbalance.security.JwtConfigurer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration
@EnableWebSecurity
@ComponentScan("edu.arf4.motivationbalance.security")
@PropertySource("classpath:custom_app.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConfigurer jwtConfigurer;
    private final UserDetailsService userDetailsService;
    @Value("${frontendAppOrigin}")
    private String frontendAppOrigin;

    public SecurityConfig(JwtConfigurer jwtConfigurer, UserDetailsService userDetailsService) {
        this.jwtConfigurer = jwtConfigurer;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
                .authorizeRequests()
                .antMatchers("/rest/auth/login", "/rest/auth/register").permitAll()
                .antMatchers("/rest/emps/by-manager/*").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/rest/emps/search-employee").hasRole("ADMIN")
                .antMatchers("/rest/emps/managers").hasRole("ADMIN")
                .antMatchers("/rest/emps/emps-without-managers").hasRole("ADMIN")
                .antMatchers("/rest/emps/change-role").hasRole("ADMIN")
                .antMatchers("/rest/emps/remove").hasRole("ADMIN")
                .antMatchers("/rest/emps/release-from-manager").hasRole("ADMIN")
                .antMatchers("/rest/emps/assign-manager/*").hasRole("ADMIN")
                .antMatchers("/rest/results/by-manager/*").hasAnyRole("ADMIN", "MANAGER")
                .antMatchers("/rest/factors/manage/**").hasRole("ADMIN")
                .antMatchers("/rest/stats/all-relev-pairs").hasRole("ADMIN")
                .anyRequest()
                .authenticated()
            .and().cors().configurationSource(corsConfigurationSource())
            .and()
                .apply(jwtConfigurer);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.applyPermitDefaultValues();
        config.setAllowedOrigins(Collections.singletonList(this.frontendAppOrigin));
        config.setAllowedMethods(Arrays.asList("GET", "POST"));
        source.registerCorsConfiguration("/**", config);
        return source;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }

}
