package com.cca.sportt.Models;

public class Avances {
    private String nivel;
    private String nombre;
    private String pesoactual;
    private String ritmocardiaco;
    private String tiempo;


    public Avances() {
    }

    public Avances(String nivel,String nombre, String pesoactual, String ritmocardiaco, String tiempo) {
        this.nivel = nivel;
        this.nombre = nombre;
        this.pesoactual = pesoactual;
        this.ritmocardiaco = ritmocardiaco;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPesoactual() {
        return pesoactual;
    }

    public void setPesoactual(String pesoactual) {
        this.pesoactual = pesoactual;
    }

    public String getRitmocardiaco() {
        return ritmocardiaco;
    }

    public void setRitmocardiaco(String ritmocardiaco) {
        this.ritmocardiaco = ritmocardiaco;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}
