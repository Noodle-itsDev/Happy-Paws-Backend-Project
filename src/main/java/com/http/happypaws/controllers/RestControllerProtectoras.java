package com.http.happypaws.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.http.happypaws.models.Protectoras;
import com.http.happypaws.services.ProtectorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/protectora/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerProtectoras {
  
  private ProtectorasService protectoraService;
  
  
  @Autowired
  public RestControllerProtectoras(ProtectorasService protectoraService){
    this.protectoraService = protectoraService;
  }
  
  @PostMapping(value = "create", headers = "Accept=application/json")
  public void crearProtectora(@RequestBody Protectoras protectoras){
    protectoraService.crearProtectora(protectoras);
  }
  
  @GetMapping(value = "all", headers = "Accept=application/json")
  public List<Protectoras> obtenerProtectoras(){
    return protectoraService.obtenerProtectoras();
  }
  
  @GetMapping(value = "{id}", headers = "Accept=application/json")
  public Optional<Protectoras> obtenerProtectoraById(@PathVariable Long id){
    return protectoraService.obtenerProtectoraById(id);
  }
  
  @PutMapping(value = "update", headers = "Accept=application/json")
  public void updateProtectora(Protectoras protectoras){
    protectoraService.updateProtectora(protectoras);
  }
  
  @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
  public void deleteProtectora(@PathVariable Long id){
    protectoraService.deleteProtectora(id);
  }
  
}
