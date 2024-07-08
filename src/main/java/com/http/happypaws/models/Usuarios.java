package com.http.happypaws.models;

import java.sql.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor 
//Genero constructor vacío

@AllArgsConstructor 
//Genero contructor con todos los atributos

@Data 
//Genero getters y setters con este comando de lombok

@ToString
//Genero método toString con lombok

@Entity
//Le indico a esta clase que es una entidad

@Table(name = "usuarios")
//Indico a qué tabla corresponde esta entidad

public class Usuarios {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	@Column(name = "usuario_id")
	private Long idUsuario;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;	
	
	@Column(name = "deleted_at")
	private Date deletedAt;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "extension")
	private int extension;
	
	@Column(name = "telefono")
	private int telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "provincia")
	private String provincia;
	
	@Column(name = "población")
	private String población;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "codigo_postal")
	private int codigoPostal;
	
	@Column(name = "is_super_admin")
	private Boolean isSuperAdmin;
	
	
}