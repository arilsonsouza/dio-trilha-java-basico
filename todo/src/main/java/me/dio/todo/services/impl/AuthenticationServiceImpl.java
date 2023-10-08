package me.dio.todo.services.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.dio.todo.controller.dto.LoginResponseDTO;
import me.dio.todo.controller.dto.UserDTO;
import me.dio.todo.domain.model.Role;
import me.dio.todo.domain.model.User;
import me.dio.todo.domain.repository.RoleRepository;
import me.dio.todo.domain.repository.UserRepository;
import me.dio.todo.services.AuthenticationService;
import me.dio.todo.services.TokenService;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public UserDTO register(String username, String password) {
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByName("USER").get();

        Set<Role> roles = new HashSet<>();

        roles.add(userRole);

        User user = userRepository.save(new User(username, encodedPassword, roles));
        return new UserDTO(user);
    }

    @Override
    public LoginResponseDTO login(String username, String password) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username, password));

            String token = tokenService.generateJwt(auth);

            User user = userRepository.findByUsername(username).get();
            return new LoginResponseDTO(new UserDTO(user), token);

        } catch (AuthenticationException e) {
            return new LoginResponseDTO(null, "");
        }
    }

}
