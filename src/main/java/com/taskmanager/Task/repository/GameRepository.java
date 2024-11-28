package com.taskmanager.Task.repository;

import com.taskmanager.Task.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
