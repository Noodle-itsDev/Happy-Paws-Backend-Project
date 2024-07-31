package com.http.happypaws.security;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.http.happypaws.models.Roles;
import com.http.happypaws.models.Usuarios;
import com.http.happypaws.repositories.IUsuariosRepository;

@Service
public class CustomUsersDetailsService implements UserDetailsService{
	
	private IUsuariosRepository usuariosRepo;
	
	@Autowired
	public CustomUsersDetailsService(IUsuariosRepository usuariosRepo) {
		this.usuariosRepo = usuariosRepo;
	}
	
	public Collection<GrantedAuthority> mapToAuthorities(List<Roles> roles){
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuarios usuarios = usuariosRepo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));
		
		return new User(usuarios.getUsername(), usuarios.getPassword(), mapToAuthorities(usuarios.getRoles()));
	}
	
	
}
