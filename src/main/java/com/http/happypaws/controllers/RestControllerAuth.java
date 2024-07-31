package com.http.happypaws.controllers;

import com.http.happypaws.services.UsuariosService;
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
import com.http.happypaws.mail.EmailSenderUtility;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import java.util.Collections;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
@RequestMapping("/api/auth/")

public class RestControllerAuth {

    private AuthenticationManager authenticationManager;
    private PasswordEncoder passwordEncoder;
    private IRolesRepository rolesRepository;
    private IUsuariosRepository usuariosRepository;
    private JwtGenerator jwtGenerator;
    private EmailSenderUtility emailSenderUtility;

    @Autowired
    public RestControllerAuth(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder, IRolesRepository rolesRepository, IUsuariosRepository usuariosRepository, JwtGenerator jwtGenerator, EmailSenderUtility emailSenderUtility) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.rolesRepository = rolesRepository;
        this.usuariosRepository = usuariosRepository;
        this.jwtGenerator = jwtGenerator;
        this.emailSenderUtility = emailSenderUtility;
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
            usuarios.setPoblacion(registerDTO.getPoblacion());
            usuarios.setCiudad(registerDTO.getCiudad());
            usuarios.setCalle(registerDTO.getCalle());
            usuarios.setNumero(registerDTO.getNumero());
            usuarios.setCodigoPostal(registerDTO.getCodigoPostal());
            usuarios.setIsSuperAdmin(0);
        
    
        Optional<Roles> rolesOptional = rolesRepository.findRoleByName("Voluntario");
        if (rolesOptional.isPresent()) {
            usuarios.setRoles(Collections.singletonList(rolesOptional.get()));
            Usuarios savedUser = usuariosRepository.save(usuarios);
            
            try {
                emailSenderUtility.sendEmail(usuarios.getEmail(), usuarios.getNombre(), savedUser.getIdUsuario());
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<>("Registro exitoso, pero no se pudo enviar el correo de confirmación", HttpStatus.OK);
            }
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

    @PostMapping("login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO dtoLogin) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    dtoLogin.getUsername(), dtoLogin.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = jwtGenerator.generateToken(authentication);

            // Obtener el usuario autenticado
            String username = dtoLogin.getUsername();
            Usuarios usuario = usuariosRepository.findByUsername(username)
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            return new ResponseEntity<>(new AuthResponseDTO(token, usuario), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    

}