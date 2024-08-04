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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerUsuarios {

    @Autowired
    private UsuariosService usuariosService;

    @PutMapping(value = "/edit/{id}")
    public ResponseEntity<Usuarios> updateUsuario(@PathVariable Long id, @RequestBody Usuarios usuario) {
        return usuariosService.updateUser(id, usuario)
                .map(updatedUsuario -> new ResponseEntity<>(updatedUsuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/validate/{id}")
    public ResponseEntity<Usuarios> actualizarIsValidated(@PathVariable Long id) {
        return usuariosService.updateValidate(id)
                .map(usuario -> new ResponseEntity<>(usuario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/all")
    public List<Usuarios> findAllUsers(){
      return usuariosService.findAllUsers();
    }
    
    @GetMapping("/{id}")
    public Optional<Usuarios> getUsuarioById(@PathVariable Long id) {
        return usuariosService.findById(id);
    }
}
