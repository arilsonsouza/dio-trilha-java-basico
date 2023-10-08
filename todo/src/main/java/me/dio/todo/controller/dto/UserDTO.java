package me.dio.todo.controller.dto;

import java.util.Set;

import me.dio.todo.domain.model.Role;
import me.dio.todo.domain.model.User;

public record UserDTO(
        Long id,
        String username,
        Set<Role> roles) {

    public UserDTO(User model) {
        this(model.getId(), model.getUsername(), model.getRoles());
    }

}