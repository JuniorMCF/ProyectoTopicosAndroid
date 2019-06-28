package com.cca.sportt.Models;

public class Niveles {
    private String descripcion;
    private String nivel;
    private String nombre;
    private String tipo;

    public Niveles() {
    }

    public Niveles(String descripcion, String nivel, String nombre, String tipo) {
        this.descripcion = descripcion;
        this.nivel = nivel;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}


