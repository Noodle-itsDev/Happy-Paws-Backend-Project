package com.http.happypaws.controllers;

import com.http.happypaws.models.Protectoras;
import com.http.happypaws.services.ProtectorasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/protectora/")
public class RestControllerProtectoras {
  private ProtectoraService protectoraService;
  
  @Autowired
  public RestControllerProtectora(ProtectoraService protectoraService){
    this.protectoraService = protectoraService;
  }
  
  @PostMapping(value = "create", headers = "Accept=application/json")
  public void crearProtectora(@RequestBody Protectoras protectoras){
    protectoraService.crearProtectora(protectoras);
  }
  
  @GetMapping(value = "all", headers = "Accept=apllication/json")
  public List<Protectoras> obtenerProtectoras(){
    return protectorasService.obtenerProtectoras();
  }
  
  @GetMapping(value = "{id}", headers = "Accept=application/json")
  public Protectoras obtenerProtectoraById(@PathVariable Long id){
    return protectorasService.obtenerProtectoraById(id);
  }
  
  @PutMapping(value = "update" headers = "Accept=application/json")
  public void updateProtectora(Protectoras protectoras){
    protectoraService.updateProtectora(protectoras);
  }
  
  @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
  public void deleteProtectora(@PathVariable Long id){
    protectoraService.deleteProtectora(id);
  }
  
}
