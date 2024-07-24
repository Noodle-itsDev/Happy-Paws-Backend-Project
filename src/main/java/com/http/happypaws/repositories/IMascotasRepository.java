package com.http.happypaws.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.http.happypaws.models.Mascotas;

@Repository
public interface IMascotasRepository extends JpaRepository<Mascotas, Long>{
	
}
