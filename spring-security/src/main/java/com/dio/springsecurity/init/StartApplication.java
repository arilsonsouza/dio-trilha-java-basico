package com.dio.springsecurity.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.dio.springsecurity.model.Role;
import com.dio.springsecurity.model.User;
import com.dio.springsecurity.repository.UserRepository;

@Component
public class StartApplication implements CommandLineRunner {

    @Autowired
    private UserRepository repository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User user = repository.getUserByUsername("admin");
        System.out.println("StartApplication=========================");
        if (user == null) {
            user = new User();
            user.setUsername("admin");
            user.setPassword(passwordEncoder.encode("password"));
            user.getRoles().add(new Role("MANAGERS"));
            repository.save(user);
        }
        user = repository.getUserByUsername("user");
        if (user == null) {
            user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("password"));
            user.getRoles().add(new Role("USERS"));
            repository.save(user);
        }
    }

}
