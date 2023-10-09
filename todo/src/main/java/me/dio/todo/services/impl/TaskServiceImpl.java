package me.dio.todo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.dio.todo.domain.model.Task;
import me.dio.todo.domain.repository.TaskRepository;
import me.dio.todo.services.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task createNewTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTask(Long userId) {
        return taskRepository.findAll(userId);
    }

    public Task findTaskById(Long id) {
        return taskRepository.getById(id);
    }

    public List<Task> findAllCompletedTask(Long userId) {
        return taskRepository.findByCompletedTrue(userId);
    }

    public List<Task> findAllInCompleteTask(Long userId) {
        return taskRepository.findByCompletedFalse(userId);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

}
