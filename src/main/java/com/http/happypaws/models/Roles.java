package com.http.happypaws.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


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

	
	public Roles() {
		
	}
	
	public Roles(Long idRole, String name, String description) {
		this.idRole = idRole;
		this.name = name;
		this.description = description;
	}

	public Long getIdRole() {
		return idRole;
	}
	
	
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}