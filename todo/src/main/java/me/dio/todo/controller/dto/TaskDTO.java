package me.dio.todo.controller.dto;

import me.dio.todo.domain.model.Task;

public record TaskDTO(
        Long id,
        Long userId,
        String task,
        boolean completed) {

    public TaskDTO(Task model) {
        this(model.getId(), model.getUser().getId(), model.getTask(), model.isCompleted());
    }

}