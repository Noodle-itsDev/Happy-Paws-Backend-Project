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
@Table(name = "mascotas")
public class mascotas {
	
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
	
	
	
	
	
	
	
	
	
		
	

	
	
	
	
	
	
	
}
