package com.http.happypaws.models;

import jakarta.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private Long eventoId;

    @Column(name = "nombre_evento")
    private String nombreEvento;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_inicio")
    private Date fechaInicio;

    @Column(name = "fecha_fin")
    private Date fechaFin;

    @Column(name = "finalizado")
    private Boolean finalizado;
    
    @Column(name="tipo_evento")
    private String tipoEvento;
    
    @Column(name="estado")
    private String estado;
    
    @Column(name="observacion")
    private String observacion;
    
    @Column(name="asistido")
    private String asistido;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private Usuarios usuario;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "protectora_id", referencedColumnName = "protectora_id")
    private Protectoras protectora;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "mascota_id", referencedColumnName = "mascota_id")
    private Mascotas mascota;

    public Eventos() {}

    public Eventos(String nombreEvento, String descripcion, Date fechaInicio, Date fechaFin, Boolean finalizado, String tipoEvento, String estado, String observacion, String asistido ,Usuarios usuario, Protectoras protectora, Mascotas mascota) {
        this.nombreEvento = nombreEvento;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.finalizado = finalizado;
        this.tipoEvento = tipoEvento;
        this.estado = estado;
        this.observacion = observacion;
        this.usuario = usuario;
        this.protectora = protectora;
        this.mascota = mascota;
        this.asistido = asistido;
    }

    // Getters y Setters
    public Long getEventoId() {
        return eventoId;
    }

    public void setEventoId(Long eventoId) {
        this.eventoId = eventoId;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    public String getTipoEvento(){
        return tipoEvento;
    }
    
    public void setTipoEvento(String tipoEvento){
        this.tipoEvento = tipoEvento;
    }
    
    public String getEstado(){
        return estado;
    }
    
    public void setEstado(String estado){
        this.estado = estado;
    }
    
    public String getObservacion(){
        return observacion;
    }
    
    public void setObservacion(String observacion){
        this.observacion = observacion;
    }
    
    public String getAsistido(){
        return asistido;
    }
    
    public void setAsistido(String asistido){
        this.asistido = asistido;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }

    public Protectoras getProtectora() {
        return protectora;
    }

    public void setProtectora(Protectoras protectora) {
        this.protectora = protectora;
    }

    public Mascotas getMascota() {
        return mascota;
    }

    public void setMascota(Mascotas mascota) {
        this.mascota = mascota;
    }
    
    @Override
    public String toString() {
        return "Eventos{" +
                "eventoId=" + eventoId +
                ", nombreEvento='" + nombreEvento + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", finalizado=" + finalizado +
                ", tipoEvento='" + tipoEvento + '\'' +
                ", estado='" + estado + '\'' +
                ", observacion='" + observacion + '\'' +
                ", asistido='" + asistido + '\'' +
                ", usuario=" + usuario +
                ", protectora=" + protectora +
                ", mascota=" + mascota +
                '}';
}

}
