package com.http.happypaws.services;

import com.http.happypaws.models.Usuarios;
import com.http.happypaws.repositories.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    private IUsuariosRepository usuariosRepository;

    public Optional<Usuarios> findByUsername(String username) {
        return usuariosRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return usuariosRepository.existsByUsername(username);
    }

    public Usuarios saveUser(Usuarios usuario) {
        return usuariosRepository.save(usuario);
    }

    public Optional<Usuarios> findById(Long id) {
        return usuariosRepository.findById(id);
    }

    public void deleteUser(Long id) {
        usuariosRepository.deleteById(id);
    }

    public Usuarios updateUser(Long id, Usuarios updatedUsuario) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    usuario.setUsername(updatedUsuario.getUsername());
                    usuario.setPassword(updatedUsuario.getPassword());
                    usuario.setNombre(updatedUsuario.getNombre());
                    usuario.setApellidos(updatedUsuario.getApellidos());
                    usuario.setDni(updatedUsuario.getDni());
                    usuario.setExtension(updatedUsuario.getExtension());
                    usuario.setTelefono(updatedUsuario.getTelefono());
                    usuario.setEmail(updatedUsuario.getEmail());
                    usuario.setProvincia(updatedUsuario.getProvincia());
                    usuario.setPoblacion(updatedUsuario.getPoblacion());
                    usuario.setCiudad(updatedUsuario.getCiudad());
                    usuario.setCalle(updatedUsuario.getCalle());
                    usuario.setNumero(updatedUsuario.getNumero());
                    usuario.setCodigoPostal(updatedUsuario.getCodigoPostal());
                    usuario.setIsSuperAdmin(updatedUsuario.getIsSuperAdmin());
                    return usuariosRepository.save(usuario);
                })
                .orElseGet(() -> {
                    return usuariosRepository.save(updatedUsuario);
                });
    }

    public Optional<Usuarios> updateValidate(Long id) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    usuario.setIsVerified(true);
                    return usuariosRepository.save(usuario);
                });
    }
}
