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
	
	//Crear eventos
	public void crearEvento(Eventos evento) {
		iEventosRepository.save(evento);
    
    Optional<Usuarios> usuario = usuarioRepository.findById(evento.getUsuario().getIdUsuario());
    Optional<Mascotas> mascota = mascotaRepository.findById(evento.getMascota().getId());
    Optional<Protectoras> protectora = protectoraRepository.findById(evento.getProtectora().getIdProtectora());

    if (usuario.isPresent() && mascota.isPresent() && protectora.isPresent()) {
      evento.setUsuario(usuario.get());
      evento.setMascota(mascota.get());
      evento.setProtectora(protectora.get());
      iEventosRepository.save(evento);
    } else {
      throw new NoSuchElementException("Usuario, Mascota o Protectora no encontrados.");
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
	
	
}