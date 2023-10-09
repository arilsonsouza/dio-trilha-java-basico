package me.dio.todo.services;

import java.util.List;

import org.springframework.stereotype.Service;

import me.dio.todo.domain.model.Task;

@Service
public interface TaskService {
    public Task createNewTask(Task task);

    public List<Task> getAllTask(Long userId);

    public Task findTaskById(Long id);

    public List<Task> findAllCompletedTask(Long userId);

    public List<Task> findAllInCompleteTask(Long userId);

    public void deleteTask(Long id);

    public Task updateTask(Task task);
}
