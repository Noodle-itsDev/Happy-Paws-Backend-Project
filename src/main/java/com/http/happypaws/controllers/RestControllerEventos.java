package com.http.happypaws.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.http.happypaws.models.Eventos;
import com.http.happypaws.services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import java.util.NoSuchElementException;
import com.http.happypaws.mail.SendNotificationUtility;
import com.http.happypaws.services.UsuariosService;
import com.http.happypaws.models.Usuarios;
import com.mailjet.client.errors.MailjetException;

@RestController
@RequestMapping("/api/eventos/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerEventos {
  
  private EventosService eventosService;
  private SendNotificationUtility sendNotificationUtility;
  private UsuariosService usuariosService;
  
  @Autowired
  public RestControllerEventos(EventosService eventosService, SendNotificationUtility sendNotificationUtility, UsuariosService usuariosService){
    this.eventosService = eventosService;
    this.sendNotificationUtility = sendNotificationUtility;
    this.usuariosService = usuariosService;
  }
  
  @PostMapping(value = "create", headers = "Accept=application/json")
  public void crearEventos(@RequestBody Eventos evento) {
      eventosService.crearEvento(evento);
      Optional<Usuarios> usuario = usuariosService.findById(evento.getUsuario().getIdUsuario());

      if (usuario.isPresent()) {
          Usuarios foundUsuario = usuario.get();
          try {
              sendNotificationUtility.sendEmail(
                  foundUsuario.getEmail(),
                  foundUsuario.getNombre(),
                  foundUsuario.getIdUsuario()
              );
          } catch (Exception e) {
              System.err.println("Error al enviar el correo: " + e.getMessage());
              e.printStackTrace();
          }
      } else {
          System.out.println("Usuario no encontrado para el ID: " + evento.getUsuario().getIdUsuario());
      }
  }

  
  @GetMapping(value = "all", headers = "Accept=application/json")
  public List<Eventos> obtenerEventos(){
    return eventosService.obtenerEventos();
  }
  
  @GetMapping(value = "{id}", headers = "Accept=application/json")
  public Optional<Eventos> obtenerEventosById(@PathVariable Long id){
    return eventosService.obtenerEventosById(id);
  }
  
  @PutMapping(value = "update", headers = "Accept=application/json")
  public void updateEvento(Eventos evento){
    eventosService.updateEvento(evento);
  }
  
  @PutMapping(value = "/state/update/{id}/{state}", headers = "Accept=application/json")
      public ResponseEntity<Void> updateEventState(@PathVariable Long id, @PathVariable int state) {
          Optional<Eventos> optionalEvento = eventosService.obtenerEventosById(id);
          
          if (optionalEvento.isPresent()) {
              Eventos evento = optionalEvento.get();
              switch (state) {
                  case 0:
                      evento.setEstado("Pendiente");
                      break;
                  case 1:
                      evento.setEstado("Aceptado");
                      break;
                  case 2:
                      evento.setEstado("Cancelado");
                      break;
                  case 3:
                      evento.setEstado("Asistido");
                      break;
                  case 4:
                      evento.setEstado("No asistido");
                      break;
                  default:
                      return ResponseEntity.badRequest().build();
              }
              eventosService.updateEvento(evento);
              return ResponseEntity.ok().build();
          } else {
              return ResponseEntity.notFound().build();
          }
      }
  
  @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
  public void deleteEvento(@PathVariable Long id){
    eventosService.deleteEvento(id);
  }
  
  @PutMapping(value="/disable/{id}", headers = "Accept=application/json")
  public void disableEventoById(@PathVariable Long id){
    eventosService.deshabilitarEventoById(id);
  }
  
	@GetMapping("/usuario/{usuarioId}")
	public ResponseEntity<List<Eventos>> obtenerEventosPorUsuario(@PathVariable Long usuarioId) {
		try {
			List<Eventos> eventos = eventosService.obtenerEventosPorUsuarioId(usuarioId);
			return ResponseEntity.ok(eventos);
		} catch (NoSuchElementException e) {
			return ResponseEntity.notFound().build();
		}
	}
  
}
