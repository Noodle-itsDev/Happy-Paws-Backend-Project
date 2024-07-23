package com.http.happypaws.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.http.happypaws.dtos.AuthResponseDTO;
import com.http.happypaws.dtos.LoginDTO;
import com.http.happypaws.dtos.RegisterDTO;
import com.http.happypaws.models.Roles;
import com.http.happypaws.models.Usuarios;
import com.http.happypaws.repositories.IRolesRepository;
import com.http.happypaws.repositories.IUsuariosRepository;
import com.http.happypaws.security.JwtGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.Collections;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerAuth {
    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private IRolesRepository rolesRepository;
    private IUsuariosRepository usuariosRepository;
    private JwtGenerator jwtGenerator;

    @Autowired
    public RestControllerAuth(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, IRolesRepository rolesRepository, IUsuariosRepository usuariosRepository, JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
        this.usuariosRepository = usuariosRepository;
        this.jwtGenerator = jwtGenerator;
    }
    //Método para poder registrar usuarios con role "user"
    @PostMapping("register")
    public ResponseEntity<String> registrar(@RequestBody RegisterDTO registerDTO) {
        if (usuariosRepository.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("el usuario ya existe, intenta con otro", HttpStatus.BAD_REQUEST);
        }
    
        Usuarios usuarios = new Usuarios();
        /**
        usuarios.setUsername(registerDTO.getUsername());
        usuarios.setPassword(passwordEncoder.encode(registerDTO.getPassword())); */
        
            usuarios.setUsername(registerDTO.getUsername());
            usuarios.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
            usuarios.setNombre(registerDTO.getNombre());
            usuarios.setApellidos(registerDTO.getApellidos());
            usuarios.setDni(registerDTO.getDni());
            usuarios.setExtension(registerDTO.getExtension());
            usuarios.setTelefono(registerDTO.getTelefono());
            usuarios.setEmail(registerDTO.getEmail());
            usuarios.setProvincia(registerDTO.getProvincia());
            usuarios.setPoblación(registerDTO.getPoblacion());
            usuarios.setCiudad(registerDTO.getCiudad());
            usuarios.setCalle(registerDTO.getCalle());
            usuarios.setNumero(registerDTO.getNumero());
            usuarios.setCodigoPostal(registerDTO.getCodigoPostal());
        
    
        Optional<Roles> rolesOptional = rolesRepository.findRoleByName("Voluntario");
        if (rolesOptional.isPresent()) {
            usuarios.setRoles(Collections.singletonList(rolesOptional.get()));
            usuariosRepository.save(usuarios);
            return new ResponseEntity<>("Registro de usuario exitoso", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró el rol de usuario", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //Método para poder guardar usuarios de tipo ADMIN
    @PostMapping("registerAdm")
    public ResponseEntity<String> registrarAdmin(@RequestBody RegisterDTO registerDTO) {
        if (usuariosRepository.existsByUsername(registerDTO.getUsername())) {
            return new ResponseEntity<>("el usuario ya existe, intenta con otro", HttpStatus.BAD_REQUEST);
        }
        Usuarios usuarios = new Usuarios();
        usuarios.setUsername(registerDTO.getUsername());
        usuarios.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Roles roles = rolesRepository.findRoleByName("ADMIN").get();
        usuarios.setRoles(Collections.singletonList(roles));
        usuariosRepository.save(usuarios);
        return new ResponseEntity<>("Registro de admin exitoso", HttpStatus.OK);
    }

    //Método para poder logear un usuario y obtener un token
    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO dtoLogin) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                dtoLogin.getUsername(), dtoLogin.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }


}