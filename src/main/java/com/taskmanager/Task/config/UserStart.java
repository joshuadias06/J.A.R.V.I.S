package com.taskmanager.Task.config;

import com.taskmanager.Task.model.User;
import com.taskmanager.Task.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;

@Configuration
public class UserStart implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("joshuadp14") == null) {
            User defaultUser = new User();
            defaultUser.setUsername("joshuadp14");
            defaultUser.setPassword("queren23012023");
            userRepository.save(defaultUser);
            System.out.println("Usuário padrão criado: admin/admin123");
        }
    }
}
