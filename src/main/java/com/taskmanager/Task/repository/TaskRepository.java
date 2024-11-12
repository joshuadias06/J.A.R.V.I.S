package com.taskmanager.Task.repository;

import com.taskmanager.Task.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository  extends JpaRepository<Task, Long> {
}
