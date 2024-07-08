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

@AllArgsConstructor
//Creo constructor con todos los atributos

@NoArgsConstructor
//Creo constructor vacío

@Data
//Creo getters y setters

@ToString
//Creo método toString

@Entity
//Le indico a esta clase que es una entidad

@Table(name = "protectoras")
//Indico la tabla a la que hacemos referencia

public class Protectoras {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "protectora_id")
	private Long idProtectora;
	
	@Column(name ="created_at")
	private Date createdAt;
	
	@Column(name ="updated_at")
	private Date updatedAt;
	
	@Column(name ="deleted_at")
	private Date deletedAt ;
	
	@Column(name ="cif")
	private String cif;
	
	@Column(name ="nombre")
	private String nombre;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="extension")
	private int extension;
	
	@Column(name ="telefono")
	private int telefono;
	
	@Column(name ="provincia")
	private String provincia;
	
	@Column(name ="poblacion")
	private String poblacion;
	
	@Column(name ="ciudad")
	private String ciudad;
	
	@Column(name ="calle")
	private String calle;
	
	@Column(name ="numero")
	private String numero;
	
	@Column(name ="codigo_postal")
	private int codigoPostal;
	
	@Column(name ="is_verified")
	private Boolean isVerified;
}
