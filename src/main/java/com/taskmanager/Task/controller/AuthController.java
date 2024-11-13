package com.taskmanager.Task.controller;

import com.taskmanager.Task.model.User;
import com.taskmanager.Task.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password){
        try{
            User user = authService.loginUser(username, password);
            return ResponseEntity.ok(user.getUsername());
        } catch (IllegalArgumentException e){
            return ResponseEntity.status(400).body(null);
        }
    }
}
