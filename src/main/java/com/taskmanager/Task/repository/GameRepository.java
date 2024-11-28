package com.taskmanager.Task.repository;

import com.taskmanager.Task.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {

    List<Game> findByProgress(int progress);

}
