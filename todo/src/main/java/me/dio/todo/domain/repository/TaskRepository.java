package me.dio.todo.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import me.dio.todo.domain.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    public Task findByTask(String task);

    @Query("SELECT t FROM Task t WHERE t.user.id = :user_id AND t.completed = true")
    public List<Task> findByCompletedTrue(@Param("user_id") Long userId);

    @Query("SELECT t FROM Task t WHERE t.user.id = :user_id AND t.completed = false")
    public List<Task> findByCompletedFalse(@Param("user_id") Long userId);

    @Query("SELECT t FROM Task t WHERE t.user.id = :user_id")
    public List<Task> findAll(@Param("user_id") Long userId);

    public Task getById(Long id);

    public void deleteById(Long id);
}
