package com.http.happypaws.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.http.happypaws.models.Mascotas;
import com.http.happypaws.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/mascota/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerMascotas {
  
  private MascotaService mascotasService;
  
  
  @Autowired
  public RestControllerMascotas(MascotaService mascotasService){
    this.mascotasService = mascotasService;
  }
  
  @PostMapping(value = "create", headers = "Accept=application/json")
  public void crearMascota(@RequestBody Mascotas mascotas){
    mascotasService.crearMascota(mascotas);
  }
  
  @GetMapping(value = "all", headers = "Accept=application/json")
  public List<Mascotas> obtenerMascotas(){
    return mascotasService.obtenerMascotas();
  }
  
  @GetMapping(value = "{id}", headers = "Accept=application/json")
  public Optional<Mascotas> obtenerMascotasById(@PathVariable Long id){
    return mascotasService.obtenerMascotasById(id);
  }
  
  @PutMapping(value = "update", headers = "Accept=application/json")
  public void updateMascotas(Mascotas mascotas){
    mascotasService.updateMascotas(mascotas);
  }
  
  @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
  public void deleteMascotas(@PathVariable Long id){
    mascotasService.deleteMascotas(id);
  }
  
}
