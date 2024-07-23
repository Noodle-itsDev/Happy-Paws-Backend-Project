package com.http.happypaws.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.http.happypaws.models.Protectoras;

@Repository
public interface IProtectorasRepository extends JpaRepository<Protectoras, Long>{
	
	//Se busca a una protectora existente o no según el cif
	Optional<Protectoras> findProtectoraByCif(String cif);
	
	//Se busca a una protectora existente o no según el nombre
	//Optional<Protectoras> findProtectoraByName(String nombre);
}
