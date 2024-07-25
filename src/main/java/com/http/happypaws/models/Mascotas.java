package com.http.happypaws.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mascotas")
public class Mascotas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="mascota_id")
    private Long id;
    
    @Column(name ="nombre")
    private String nombre;

    @Column(name ="especie")
    private String especie;
    
    @Column(name ="raza")
    private String raza;
    
    @Column(name ="genero")
    private String genero;
    
    @Column(name ="edad")
    private int edad;
    
    @Column(name ="chip")
    private Boolean chip;

    @Column(name ="numero_chip")
    private String numeroChip;
    
    @Column(name ="estado")
    private String estado;
    
    @Column(name ="vacunado")
    private Boolean vacunado;
    
    @Column(name="esterilizacion")
    private Boolean esterilizacion;
    
    @Column(name ="desparasitacion_interna")
    private Boolean desparasitacionInterna;
    
    @Column(name ="desparasitacion_externa")
    private Boolean desparasitacionExterna;
 
    @Column(name ="tratamientos")
    private String tratamientos;
    
    @Column(name ="alergias")
    private String alergias;
    
    @Column(name ="socializacion")
    private String socializacion;
    
    @Column(name ="informacion_comportamiento")
    private String informacionComportamiento;
    
    @Column(name ="incidentes")
    private String incidentes;
    
    @Column(name="fecha_defuncion")
    private Date fechaDefuncion;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "protectora_id")
    private Protectoras protectora;
 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="usuario_id")
    private Usuarios adoptante;
 
    @JsonIgnore
    @OneToMany(mappedBy = "mascota", fetch = FetchType.LAZY)
    private List<Eventos> eventos = new ArrayList<>();
    
    public Mascotas() {
    }
    
    public Mascotas(Long id, String nombre, String especie, String raza, String genero, int edad, Boolean chip,
            String numeroChip, String estado, Boolean vacunado, Boolean esterilizacion, Boolean desparasitacionInterna,
            Boolean desparasitacionExterna, String tratamientos, String alergias, String socializacion,
            String informacionComportamiento, String incidentes, Date fechaDefuncion) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.genero = genero;
        this.edad = edad;
        this.chip = chip;
        this.numeroChip = numeroChip;
        this.estado = estado;
        this.vacunado = vacunado;
        this.esterilizacion = esterilizacion;
        this.desparasitacionInterna = desparasitacionInterna;
        this.desparasitacionExterna = desparasitacionExterna;
        this.tratamientos = tratamientos;
        this.alergias = alergias;
        this.socializacion = socializacion;
        this.informacionComportamiento = informacionComportamiento;
        this.incidentes = incidentes;
        this.fechaDefuncion = fechaDefuncion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Boolean getChip() {
        return chip;
    }

    public void setChip(Boolean chip) {
        this.chip = chip;
    }

    public String getNumeroChip() {
        return numeroChip;
    }

    public void setNumeroChip(String numeroChip) {
        this.numeroChip = numeroChip;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Boolean getVacunado() {
        return vacunado;
    }

    public void setVacunado(Boolean vacunado) {
        this.vacunado = vacunado;
    }

    public Boolean getEsterilizacion() {
        return esterilizacion;
    }

    public void setEsterilizacion(Boolean esterilizacion) {
        this.esterilizacion = esterilizacion;
    }

    public Boolean getDesparasitacionInterna() {
        return desparasitacionInterna;
    }

    public void setDesparasitacionInterna(Boolean desparasitacionInterna) {
        this.desparasitacionInterna = desparasitacionInterna;
    }

    public Boolean getDesparasitacionExterna() {
        return desparasitacionExterna;
    }

    public void setDesparasitacionExterna(Boolean desparasitacionExterna) {
        this.desparasitacionExterna = desparasitacionExterna;
    }

    public String getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(String tratamientos) {
        this.tratamientos = tratamientos;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getSocializacion() {
        return socializacion;
    }

    public void setSocializacion(String socializacion) {
        this.socializacion = socializacion;
    }

    public String getInformacionComportamiento() {
        return informacionComportamiento;
    }

    public void setInformacionComportamiento(String informacionComportamiento) {
        this.informacionComportamiento = informacionComportamiento;
    }

    public String getIncidentes() {
        return incidentes;
    }

    public void setIncidentes(String incidentes) {
        this.incidentes = incidentes;
    }

    public Date getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaDefuncion(Date fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public Protectoras getProtectora() {
        return protectora;
    }

    public void setProtectora(Protectoras protectora) {
        this.protectora = protectora;
    }

    public Usuarios getAdoptante() {
        return adoptante;
    }

    public void setAdoptante(Usuarios adoptante) {
        this.adoptante = adoptante;
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }
}
