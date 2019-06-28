package com.cca.sportt.Models;

public class Deporte {
    private String nombre;
    private String urlfoto;

    public Deporte() {
    }

    public Deporte(String nombre, String urlfoto) {
        this.nombre = nombre;
        this.urlfoto = urlfoto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(String urlfoto) {
        this.urlfoto = urlfoto;
    }
}
