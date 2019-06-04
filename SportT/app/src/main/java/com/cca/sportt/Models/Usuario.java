package com.cca.sportt.Models;

public class Usuario {
    private String nombre;
    private String username;
    private String password;
    private String Peso;
    private String edad;
    private String altura;
    private String fec_creacion;
    private String correo;

    public Usuario() {
    }

    public Usuario(String nombre, String username, String correo, String password) {
        this.nombre = nombre;
        this.username = username;
        this.correo = correo;
        this.password = password;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPeso() {
        return Peso;
    }

    public void setPeso(String peso) {
        Peso = peso;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    public String getFec_creacion() {
        return fec_creacion;
    }

    public void setFec_creacion(String fec_creacion) {
        this.fec_creacion = fec_creacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}

