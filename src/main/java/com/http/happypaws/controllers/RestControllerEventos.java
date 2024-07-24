package com.http.happypaws.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.http.happypaws.models.Eventos;
import com.http.happypaws.services.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/eventos/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerEventos {
  
  private EventosService eventosService;
  
  
  @Autowired
  public RestControllerEventos(EventosService eventosService){
    this.eventosService = eventosService;
  }
  
  @PostMapping(value = "create", headers = "Accept=application/json")
  public void crearEventos(@RequestBody Eventos evento){
    eventosService.crearEvento(evento);
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
  
  @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
  public void deleteEvento(@PathVariable Long id){
    eventosService.deleteEvento(id);
  }
  
}
