package com.http.happypaws.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.http.happypaws.models.Roles;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long>{
	
	//Encontrar el rol por el nombre :).
	Optional<Roles> findRoleByName (String Name);
	
}
