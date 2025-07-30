package com.day7proj1phase2.helloworld.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class InfoController {
    
    @GetMapping("/info")
    public String getInfo() {   
        return "This is a simple Spring Boot project demo.";
    }
}
