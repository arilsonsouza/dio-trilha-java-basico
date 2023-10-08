package me.dio.todo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin("*")
public class AdminController {

    @GetMapping
    public String helloAdmin(Authentication authentication) {
        return "Admin access level: " + authentication.getName();
    }
}
