package me.dio.todo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.todo.controller.dto.TaskDTO;
import me.dio.todo.domain.model.Task;
import me.dio.todo.domain.model.User;
import me.dio.todo.domain.repository.UserRepository;
import me.dio.todo.services.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskService taskService;

    @GetMapping()
    public ResponseEntity<List<TaskDTO>> getAllTasks(Authentication authentication) {
        User user = getCurrentUser(authentication.getName());
        List<Task> tasks = taskService.getAllTask(user.getId());

        return ResponseEntity.ok(getTasksDTO(tasks));
    }

    @GetMapping("/completed")
    public ResponseEntity<List<TaskDTO>> getAllCompletedTasks(Authentication authentication) {
        User user = getCurrentUser(authentication.getName());
        List<Task> tasks = taskService.findAllCompletedTask(user.getId());
        return ResponseEntity.ok(getTasksDTO(tasks));
    }

    @GetMapping("/incomplete")
    public ResponseEntity<List<TaskDTO>> getAllIncompleteTasks(Authentication authentication) {
        User user = getCurrentUser(authentication.getName());
        List<Task> tasks = taskService.findAllInCompleteTask(user.getId());
        return ResponseEntity.ok(getTasksDTO(tasks));
    }

    @PostMapping()
    public ResponseEntity<TaskDTO> createTask(Authentication authentication, @RequestBody Task task) {
        User user = getCurrentUser(authentication.getName());
        task.setUser(user);
        task = taskService.createNewTask(task);
        return ResponseEntity.ok(new TaskDTO(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(Authentication authentication, @PathVariable Long id,
            @RequestBody Task task) {
        User user = getCurrentUser(authentication.getName());
        task.setUser(user);
        task.setId(id);
        task = taskService.updateTask(task);
        return ResponseEntity.ok(new TaskDTO(task));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok(true);
    }

    private User getCurrentUser(String username) {
        return userRepository.findByUsername(username).get();
    }

    private List<TaskDTO> getTasksDTO(List<Task> tasks) {
        return tasks.stream().map(TaskDTO::new).collect(Collectors.toList());
    }
}
