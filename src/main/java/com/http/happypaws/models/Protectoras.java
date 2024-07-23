package com.http.happypaws.models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


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
	
	@ManyToMany(mappedBy = "protectoras")
	private List<Usuarios> usuarios = new ArrayList<>();
	
	public Protectoras() {
		
	}

	public Protectoras(Long idProtectora, Date createdAt, Date updatedAt, Date deletedAt, String cif, String nombre,
			String email, int extension, int telefono, String provincia, String poblacion, String ciudad, String calle,
			String numero, int codigoPostal, Boolean isVerified, List<Usuarios> usuarios) {
		super();
		this.idProtectora = idProtectora;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.cif = cif;
		this.nombre = nombre;
		this.email = email;
		this.extension = extension;
		this.telefono = telefono;
		this.provincia = provincia;
		this.poblacion = poblacion;
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.isVerified = isVerified;
		this.usuarios = usuarios;
	}

	public Long getIdProtectora() {
		return idProtectora;
	}

	public void setIdProtectora(Long idProtectora) {
		this.idProtectora = idProtectora;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Boolean getIsVerified() {
		return isVerified;
	}

	public void setIsVerified(Boolean isVerified) {
		this.isVerified = isVerified;
	}

	public List<Usuarios> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuarios> usuarios) {
		this.usuarios = usuarios;
	}
		
}
