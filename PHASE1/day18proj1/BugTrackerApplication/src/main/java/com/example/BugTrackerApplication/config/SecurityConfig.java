package com.example.BugTrackerApplication.config;

import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
 
    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withUsername("admin")
        .password("{noop}admin")
        .roles("ADMIN")
        .build();
        
        UserDetails user = User.withUsername("user")
        .password("{noop}user")
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf->csrf.disable())
                 .authorizeHttpRequests(auth->auth
                 .requestMatchers("/api/bugs/admin/**").hasRole("ADMIN")
                 .requestMatchers("/api/bugs/user/**").hasRole("USER")
                 .requestMatchers("/api/bugs/**").hasAnyRole("ADMIN", "USER")
                 .anyRequest().authenticated()
                 )
                 .httpBasic();

        return http.build();
    }
}