package com.cca.sportt.Models;

public class Deportes {
    private  String competitividad;
    private String descripcion;
    private String foto;
    private String nombre;
    private String tipoentrenamiento;

    public Deportes() {
    }


    public Deportes(String competitividad, String descripcion, String foto, String nombre, String tipoentrenamiento) {
        this.competitividad = competitividad;
        this.descripcion = descripcion;
        this.foto = foto;
        this.nombre = nombre;
        this.tipoentrenamiento = tipoentrenamiento;
    }


    public String getCompetitividad() {
        return competitividad;
    }

    public void setCompetitividad(String competitividad) {
        this.competitividad = competitividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoentrenamiento() {
        return tipoentrenamiento;
    }

    public void setTipoentrenamiento(String tipoentrenamiento) {
        this.tipoentrenamiento = tipoentrenamiento;
    }
}
