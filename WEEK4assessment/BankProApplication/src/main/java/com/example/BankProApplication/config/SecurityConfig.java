package com.example.BankProApplication.config;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.context.annotation.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
@Configuration

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
                 .requestMatchers("/accounts/admin/**").hasRole("ADMIN")
                 .requestMatchers("/accounts/user/**").hasRole("USER")
                 .requestMatchers("/accounts/**").hasAnyRole("ADMIN", "USER")
                 .requestMatchers("/customers/admin/**").hasRole("ADMIN")
                 .requestMatchers("/customers/user/**").hasRole("USER")
                 .requestMatchers("/customers/**").hasAnyRole("ADMIN", "USER")
                 .requestMatchers("/transactions/admin/**").hasRole("ADMIN")
                 .requestMatchers("/transactions/user/**").hasRole("USER")
                 .requestMatchers("/transactions/**").hasAnyRole("ADMIN", "USER")
                 .anyRequest().authenticated()
                 )
                 .httpBasic();

        return http.build();
    }
}
