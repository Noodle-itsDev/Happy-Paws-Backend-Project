package com.http.happypaws.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.http.happypaws.models.Usuarios;

@Repository

public interface IUsuariosRepository extends JpaRepository<Usuarios, Long>{
	
	//Se crea una custom function para encontrar por el nombre de usuario a un usuario :).
	Optional<Usuarios> findByUsername(String username);
	
	//Pregunto a la base de datos si un usuario existe o no. 
	Boolean existsByUsername(String username);
}
