package com.http.happypaws.dtos;

public class RegisterDTO {
    
    private String username;
    private String password;
    private String nombre;
    private String apellidos;
    private String dni;
    private int extension;
    private int telefono;
    private String email;
    private String provincia;
    private String poblacion;
    private String ciudad;
    private String calle;
    private String numero;
    private int codigoPostal;
    
    public RegisterDTO() {
    }
    
    public RegisterDTO(String username, String password, String nombre, String apellidos, String dni, int extension, int telefono, String email, String provincia, String poblacion, String ciudad, String calle, String numero, int codigoPostal) {
        this.username = username;
        this.password = password;
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
}