package me.dio.todo.controller.dto;

public record LoginResponseDTO(
        UserDTO user,
        String jwt) {
}