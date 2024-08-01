package com.http.happypaws.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.http.happypaws.models.Eventos;
import java.util.List;
import com.http.happypaws.models.Usuarios;

@Repository
public interface IEventosRepository extends JpaRepository<Eventos, Long>{
    List<Eventos> findByUsuario(Usuarios usuario);
}
