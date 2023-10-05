package com.dio.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Welcome to My Spring Boot Web API";
    }

    @GetMapping("/api/users")
    public String users() {
        return "Authorized user";
    }

    @GetMapping("/api/managers")
    public String managers() {
        return "Authorized manager";
    }
}
