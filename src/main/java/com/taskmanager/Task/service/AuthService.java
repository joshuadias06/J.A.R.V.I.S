package com.taskmanager.Task.service;

import com.taskmanager.Task.model.User;
import com.taskmanager.Task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;
    public User loginUser(String username, String password){
        User user = userRepository.findByUsername(username);

        if(user == null || !user.getPassword().equals(password)){
            throw new IllegalArgumentException("Credenciais inválidas!");
        }
        return user;
    }
}
