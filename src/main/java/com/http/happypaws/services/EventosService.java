package com.http.happypaws.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.NoSuchElementException;
import com.http.happypaws.models.*;
import com.http.happypaws.repositories.IEventosRepository;
import com.http.happypaws.repositories.IProtectorasRepository;
import com.http.happypaws.repositories.IUsuariosRepository;
import com.http.happypaws.repositories.IMascotasRepository;
import com.http.happypaws.models.Usuarios;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

@Service
public class EventosService {
	private IEventosRepository iEventosRepository;
 
  @Autowired
  private IUsuariosRepository usuarioRepository;
    
  @Autowired
  private IMascotasRepository mascotaRepository;
    
  @Autowired
  private IProtectorasRepository protectoraRepository;

	@Autowired
	public EventosService(IEventosRepository iEventosRepository) {
		this.iEventosRepository = iEventosRepository;
	}
	
public void crearEvento(Eventos evento) {
    System.out.println("Creating event: " + evento);

    if (evento.getUsuario() != null && evento.getUsuario().getIdUsuario() != null) {
        Long usuarioId = evento.getUsuario().getIdUsuario();
        Optional<Usuarios> usuario = usuarioRepository.findById(usuarioId);

        if (usuario.isPresent()) {
            evento.setUsuario(usuario.get());
            System.out.println("Usuario encontrado: " + usuario.get());

            if (evento.getMascota() != null && evento.getMascota().getId() != null) {
                Optional<Mascotas> mascota = mascotaRepository.findById(evento.getMascota().getId());
                if (mascota.isPresent()) {
                    evento.setMascota(mascota.get());
                } else {
                    System.out.println("Mascota no encontrada: " + evento.getMascota().getId());
                }
            }

            if (evento.getProtectora() != null && evento.getProtectora().getIdProtectora() != null) {
                Optional<Protectoras> protectora = protectoraRepository.findById(evento.getProtectora().getIdProtectora());
                if (protectora.isPresent()) {
                    evento.setProtectora(protectora.get());
                } else {
                    System.out.println("Protectora no encontrada: " + evento.getProtectora().getIdProtectora());
                }
            }

            // Establecer estado por defecto si no se proporciona
            if (evento.getEstado() == null) {
                evento.setEstado("Activo");
            }

            // Establecer tipoEvento si no se proporciona
            if (evento.getTipoEvento() == null) {
                evento.setTipoEvento(evento.getNombreEvento());
            }

            iEventosRepository.save(evento);
        } else {
            throw new NoSuchElementException("Usuario no encontrado.");
        }
    } else {
        throw new IllegalArgumentException("Usuario no proporcionado.");
    }
}

	
	//Obtener eventos
	public List<Eventos> obtenerEventos(){
		return iEventosRepository.findAll();	
	}
	
	//Obtener evento por ID
	public Optional<Eventos> obtenerEventosById(Long id){
		return iEventosRepository.findById(id);
	}
	
	//Se actualizan los datos de un evento
	public void updateEvento(Eventos evento) {
		iEventosRepository.save(evento);
	}
	
	//Se elimina protectora por ID
	public void deleteEvento(Long id) {
		iEventosRepository.deleteById(id);
	}
 
  // Eliminacion logica
  public void deshabilitarEventoById(Long id) {
      Optional<Eventos> eventoOptional = iEventosRepository.findById(id);
      if (eventoOptional.isPresent()) {
          Eventos evento = eventoOptional.get();
          evento.setEstado("Inactivo");
          iEventosRepository.save(evento);
      } else {
          throw new NoSuchElementException("Evento no encontrado");
      }
  }

 
	public List<Eventos> obtenerEventosPorUsuarioId(Long usuarioId) {
		Usuarios usuario = usuarioRepository.findById(usuarioId)
				.orElseThrow(() -> new NoSuchElementException("Usuario no encontrado"));
		List<Eventos> eventos = iEventosRepository.findByUsuario(usuario);

		// Establecer el usuario en cada evento
		for (Eventos evento : eventos) {
			evento.setUsuario(usuario);
		}

		return eventos;
	}

	
}