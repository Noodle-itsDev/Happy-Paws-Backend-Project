package com.http.happypaws.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.http.happypaws.models.Usuarios;
import com.http.happypaws.services.UsuariosService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerUsuarios {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/validate/{id}")
    public ResponseEntity<Usuarios> actualizarIsValidated(@PathVariable Long id) {
        return usuariosService.updateValidate(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
