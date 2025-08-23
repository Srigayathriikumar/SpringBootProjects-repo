package com.example.EcommerceApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import com.example.EcommerceApplication.service.JwtService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), 
                    loginRequest.getPassword()
                )
            );
            
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            
            String token = jwtService.generateToken(userDetails.getUsername());
            
            return ResponseEntity.ok(new LoginResponse(
                "Login successful", 
                userDetails.getUsername(),
                userDetails.getAuthorities().toString(),
                token
            ));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid credentials");
        }
    }

    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    public static class LoginResponse {
        private String message;
        private String username;
        private String roles;
        private String token;

        public LoginResponse(String message, String username, String roles, String token) {
            this.message = message;
            this.username = username;
            this.roles = roles;
            this.token = token;
        }

        public String getMessage() { return message; }
        public String getUsername() { return username; }
        public String getRoles() { return roles; }
        public String getToken() { return token; }
    }
}