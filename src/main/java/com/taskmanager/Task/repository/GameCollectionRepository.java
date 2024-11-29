package com.taskmanager.Task.repository;

import com.taskmanager.Task.model.Game;
import com.taskmanager.Task.model.GameCollection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameCollectionRepository  extends JpaRepository<GameCollection, String> {

    Optional<GameCollection> findByName(String name);

}
