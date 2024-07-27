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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuarios")
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
	
	@Column(name = "poblacion") 
	private String poblacion;
	
	@Column(name = "ciudad")
	private String ciudad;
	
	@Column(name = "calle")
	private String calle;
	
	@Column(name = "numero")
	private String numero;
	
	@Column(name = "codigo_postal")
	private int codigoPostal;
	
	@Column(name = "is_super_admin")
	private int isSuperAdmin;
 
  @Column(name = "is_verified")
  private boolean isVerified = false;
 
  @JsonIgnore
  @OneToMany(mappedBy = "adoptante", fetch = FetchType.LAZY)
  private List<Mascotas> mascotas = new ArrayList<>();
 
  @JsonIgnore
  @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
  private List<Eventos> eventos = new ArrayList<>();
 
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "id_role", referencedColumnName = "role_id")
	)
	private List<Roles> roles = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "usuarios_protectoras",
			joinColumns = @JoinColumn(name = "id_usuario", referencedColumnName = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "id_protectora", referencedColumnName = "protectora_id")
	)
	private List<Protectoras> protectoras = new ArrayList<>();
		
	public Usuarios() {}

	public Usuarios(Long idUsuario, String username, String password, Date createdAt, Date updatedAt, Date deletedAt,
			String nombre, String apellidos, String dni, int extension, int telefono, String email, String provincia,
			String poblacion, String ciudad, String calle, String numero, int codigoPostal, int isSuperAdmin, Boolean isVerified,
			List<Roles> roles, List<Protectoras> protectoras, List<Mascotas> mascotas, List<Eventos> eventos) {
		this.idUsuario = idUsuario;
		this.username = username;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.extension = extension;
		this.telefono = telefono;
		this.email = email;
		this.provincia = provincia;
		this.poblacion = poblacion;
		this.ciudad = ciudad;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.isSuperAdmin = isSuperAdmin;
		this.roles = roles;
		this.protectoras = protectoras;
		this.mascotas = mascotas;
		this.eventos = eventos;
    this.isVerified = isVerified;
	}

	// Getters y Setters
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getIsSuperAdmin() {
		return isSuperAdmin;
	}

	public void setIsSuperAdmin(int isSuperAdmin) {
		this.isSuperAdmin = isSuperAdmin;
	}
 
  public boolean getIsVerified() {
    return isVerified;
  }

  public void setIsVerified(boolean isVerified) {
    this.isVerified = isVerified;
  }

	public List<Roles> getRoles() {
		return roles;
	}

	public void setRoles(List<Roles> roles) {
		this.roles = roles;
	}

	public List<Protectoras> getProtectoras() {
		return protectoras;
	}

	public void setProtectoras(List<Protectoras> protectoras) {
		this.protectoras = protectoras;
	}

	public List<Mascotas> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascotas> mascotas) {
		this.mascotas = mascotas;
	}

	public List<Eventos> getEventos() {
		return eventos;
	}

	public void setEventos(List<Eventos> eventos) {
		this.eventos = eventos;
	}
}
