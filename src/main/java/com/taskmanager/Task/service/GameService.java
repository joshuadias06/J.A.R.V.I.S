package com.taskmanager.Task.service;

import com.taskmanager.Task.model.Game;
import com.taskmanager.Task.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    //CREATE: Adicionar um novo jogo.
    public Game addGame(Game game) {
        return gameRepository.save(game);
    }

    //READ: Busca todos os jogos.
    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

    //READ: Busca todos os jogos pelo ID.
    public Optional<Game> getGameById(Long id){
        return gameRepository.findById(id);
    }

    //READ: Lista todos os jogos pelo progresso.
    public List<Game> getGameByProgress(Integer progress){
        return gameRepository.findByProgress(progress);
    }

    //UPDATE: Atualiza um jogo existente.
    public Game updateGame(Long id, Game gameDetails){
        if(gameRepository.existsById(id)){
            gameDetails.setId(id);
            return gameRepository.save(gameDetails);
        }else {
            return null;
        }
    }

    //DELETE: Exclui um jogo.
    public boolean deleteGame(Long id){
        if(gameRepository.existsById(id)){
            gameRepository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }
}
