package com.http.happypaws.models;

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
//Genero constructor con todos los atributos

@NoArgsConstructor
//Genero constructor vacío

@Data
//Genero getters y setters con lombok

@ToString
//Genero método toString con lombok

@Entity
//Le indico a esta clase que es una entidad

@Table(name = "roles")
public class Roles {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "role_id")
	private Long idRole;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
}