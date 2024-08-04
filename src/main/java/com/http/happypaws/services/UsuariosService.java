package com.http.happypaws.services;

import com.http.happypaws.models.Usuarios;
import com.http.happypaws.repositories.IUsuariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;


@Service
public class UsuariosService {

    @Autowired
    private IUsuariosRepository usuariosRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public Optional<Usuarios> findByUsername(String username) {
        return usuariosRepository.findByUsername(username);
    }
    
    public List<Usuarios> findAllUsers(){
        return usuariosRepository.findAll();
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

    public Optional<Usuarios> updateUser(Long id, Usuarios updatedUsuario) {
        Optional<Usuarios> usuarioOldOptional = usuariosRepository.findById(id);
        if (usuarioOldOptional.isPresent()) {
            Usuarios usuarioOld = usuarioOldOptional.get();
    
            if (updatedUsuario.getUsername() != null && !updatedUsuario.getUsername().equals(usuarioOld.getUsername())) {
                usuarioOld.setUsername(updatedUsuario.getUsername());
            }
    
            if (updatedUsuario.getPassword() != null && !updatedUsuario.getPassword().equals(usuarioOld.getPassword())) {
                usuarioOld.setPassword(passwordEncoder.encode(updatedUsuario.getPassword()));
            }
    
            if (updatedUsuario.getNombre() != null && !updatedUsuario.getNombre().equals(usuarioOld.getNombre())) {
                usuarioOld.setNombre(updatedUsuario.getNombre());
            }
    
            if (updatedUsuario.getApellidos() != null && !updatedUsuario.getApellidos().equals(usuarioOld.getApellidos())) {
                usuarioOld.setApellidos(updatedUsuario.getApellidos());
            }
    
            if (updatedUsuario.getDni() != null && !updatedUsuario.getDni().equals(usuarioOld.getDni())) {
                usuarioOld.setDni(updatedUsuario.getDni());
            }

            usuarioOld.setExtension(updatedUsuario.getExtension());
            usuarioOld.setTelefono(updatedUsuario.getTelefono());
    
            if (updatedUsuario.getEmail() != null && !updatedUsuario.getEmail().equals(usuarioOld.getEmail())) {
                usuarioOld.setEmail(updatedUsuario.getEmail());
            }
    
            if (updatedUsuario.getProvincia() != null && !updatedUsuario.getProvincia().equals(usuarioOld.getProvincia())) {
                usuarioOld.setProvincia(updatedUsuario.getProvincia());
            }
    
            if (updatedUsuario.getPoblacion() != null && !updatedUsuario.getPoblacion().equals(usuarioOld.getPoblacion())) {
                usuarioOld.setPoblacion(updatedUsuario.getPoblacion());
            }
    
            if (updatedUsuario.getCiudad() != null && !updatedUsuario.getCiudad().equals(usuarioOld.getCiudad())) {
                usuarioOld.setCiudad(updatedUsuario.getCiudad());
            }
    
            if (updatedUsuario.getCalle() != null && !updatedUsuario.getCalle().equals(usuarioOld.getCalle())) {
                usuarioOld.setCalle(updatedUsuario.getCalle());
            }
    
            usuarioOld.setNumero(updatedUsuario.getNumero());
    
            if (updatedUsuario.getCodigoPostal() != 0 && updatedUsuario.getCodigoPostal() != usuarioOld.getCodigoPostal()) {
                usuarioOld.setCodigoPostal(updatedUsuario.getCodigoPostal());
            }
    
            usuariosRepository.save(usuarioOld);
            return Optional.of(usuarioOld);
        } else {
            return Optional.empty();
        }
    }



    public Optional<Usuarios> updateValidate(Long id) {
        return usuariosRepository.findById(id)
                .map(usuario -> {
                    usuario.setIsVerified(true);
                    return usuariosRepository.save(usuario);
                });
    }
}
