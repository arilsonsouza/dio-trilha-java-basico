package me.dio.todo.services;

import me.dio.todo.controller.dto.LoginResponseDTO;
import me.dio.todo.controller.dto.UserDTO;

public interface AuthenticationService {

    public UserDTO register(String username, String password);

    public LoginResponseDTO login(String username, String password);
}
