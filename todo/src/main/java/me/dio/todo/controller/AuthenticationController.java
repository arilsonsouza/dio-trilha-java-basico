package me.dio.todo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.todo.controller.dto.LoginResponseDTO;
import me.dio.todo.controller.dto.RegistrationDTO;
import me.dio.todo.controller.dto.UserDTO;
import me.dio.todo.services.AuthenticationService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public record AuthenticationController(AuthenticationService authenticationService) {

    @PostMapping("/register")
    public ResponseEntity<UserDTO> registe(@RequestBody RegistrationDTO body) {
        UserDTO user = authenticationService.register(body.username(), body.password());

        return ResponseEntity.ok().body(user);

    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody RegistrationDTO body) {
        return authenticationService.login(body.username(), body.password());
    }
}
