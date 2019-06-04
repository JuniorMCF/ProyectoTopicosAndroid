package com.cca.sportt.Models;

public class Principal {
    private int urlfoto;
    private String nameprincipal;

    public Principal() {
    }

    public Principal(int urlfoto, String nameprincipal) {
        this.urlfoto = urlfoto;
        this.nameprincipal = nameprincipal;
    }

    public int getUrlfoto() {
        return urlfoto;
    }

    public void setUrlfoto(int urlfoto) {
        this.urlfoto = urlfoto;
    }

    public String getNamedeporte() {
        return nameprincipal;
    }

    public void setNamedeporte(String namedeporte) {
        this.nameprincipal = namedeporte;
    }
}
