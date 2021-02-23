package edu.arf4.motivationbalance.config;

import edu.arf4.motivationbalance.security.JwtConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ComponentScan("edu.arf4.motivationbalance.security")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConfigurer jwtConfigurer;
    private final UserDetailsService userDetailsService;

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
                .antMatchers("/", "/rest/auth/login", "/rest/auth/register").permitAll()
                .antMatchers("/rest/emps/by-manager/*").hasAnyRole("ADMIN", "MANAGER")
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
            .and().cors()
            .and()
                .apply(jwtConfigurer);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    protected PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }



}
