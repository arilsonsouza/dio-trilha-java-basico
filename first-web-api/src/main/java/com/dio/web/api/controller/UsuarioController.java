package com.dio.web.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dio.web.api.model.Usuario;
import com.dio.web.api.repository.UsuarioRepository;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Users", description = "Users endpoints")
@RestController
@RequestMapping(path = "users")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> getUsers() {
        return usuarioRepository.listAll();
    }

    @GetMapping("/{user_id}")
    public Usuario getUser(@PathVariable("user_id") Integer userId) {
        return usuarioRepository.finById(userId);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable("user_id") Integer userId) {
        usuarioRepository.remove(userId);
    }

    @PostMapping
    public void createUser(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
    }
}
