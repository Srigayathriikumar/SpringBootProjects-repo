package com.day7proj1phase1.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello, World! This is a Spring Boot application.";
    }

    @GetMapping("/greet")
    public String greet() {
        return "Greetings from the Spring Boot application!";
    }
}
