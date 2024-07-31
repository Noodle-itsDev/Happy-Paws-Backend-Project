package com.http.happypaws.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.http.happypaws.models.Mascotas;
import com.http.happypaws.services.MascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import com.http.happypaws.services.CloudinaryService;
import org.springframework.web.multipart.MultipartFile;
import java.sql.Date;

@RestController
@RequestMapping("/api/mascota/")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerMascotas {

    private final MascotaService mascotasService;
    private final CloudinaryService cloudinaryService;

    @Autowired
    public RestControllerMascotas(MascotaService mascotasService, CloudinaryService cloudinaryService) {
        this.mascotasService = mascotasService;
        this.cloudinaryService = cloudinaryService;
    }

    @PostMapping(value = "create", headers = "Accept=application/json")
    public void crearMascota(@RequestParam("file") MultipartFile file,
                             @RequestParam("nombre") String nombre,
                             @RequestParam("especie") String especie,
                             @RequestParam("raza") String raza,
                             @RequestParam("genero") String genero,
                             @RequestParam("edad") int edad,
                             @RequestParam("chip") Boolean chip,
                             @RequestParam("numeroChip") String numeroChip,
                             @RequestParam("estado") String estado,
                             @RequestParam("vacunado") Boolean vacunado,
                             @RequestParam("esterilizacion") Boolean esterilizacion,
                             @RequestParam("desparasitacionInterna") Boolean desparasitacionInterna,
                             @RequestParam("desparasitacionExterna") Boolean desparasitacionExterna,
                             @RequestParam("tratamientos") String tratamientos,
                             @RequestParam("alergias") String alergias,
                             @RequestParam("socializacion") String socializacion,
                             @RequestParam("informacionComportamiento") String informacionComportamiento,
                             @RequestParam("incidentes") String incidentes) {
        String imageUrl = cloudinaryService.uploadFile(file);
        
        Mascotas mascota = new Mascotas();
        mascota.setNombre(nombre);
        mascota.setEspecie(especie);
        mascota.setRaza(raza);
        mascota.setGenero(genero);
        mascota.setEdad(edad);
        mascota.setChip(chip);
        mascota.setNumeroChip(numeroChip);
        mascota.setEstado(estado);
        mascota.setVacunado(vacunado);
        mascota.setEsterilizacion(esterilizacion);
        mascota.setDesparasitacionInterna(desparasitacionInterna);
        mascota.setDesparasitacionExterna(desparasitacionExterna);
        mascota.setTratamientos(tratamientos);
        mascota.setAlergias(alergias);
        mascota.setSocializacion(socializacion);
        mascota.setInformacionComportamiento(informacionComportamiento);
        mascota.setIncidentes(incidentes);
        mascota.setImagen(imageUrl);
        
        mascotasService.crearMascota(mascota); // Guardar la mascota en la base de datos
    }

    @GetMapping(value = "all", headers = "Accept=application/json")
    public List<Mascotas> obtenerMascotas() {
        return mascotasService.obtenerMascotas();
    }

    @GetMapping(value = "{id}", headers = "Accept=application/json")
    public Optional<Mascotas> obtenerMascotasById(@PathVariable Long id) {
        return mascotasService.obtenerMascotasById(id);
    }

    @PutMapping(value = "update", headers = "Accept=application/json")
    public void updateMascotas(@RequestBody Mascotas mascotas) {
        mascotasService.updateMascotas(mascotas);
    }

    @DeleteMapping(value = "delete/{id}", headers = "Accept=application/json")
    public void deleteMascotas(@PathVariable Long id) {
        mascotasService.deleteMascotas(id);
    }
}
