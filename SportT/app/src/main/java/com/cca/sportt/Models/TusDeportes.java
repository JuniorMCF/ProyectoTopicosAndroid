package com.cca.sportt.Models;

import java.util.List;

public class TusDeportes {
    private Avances avance;
    private Deportes deporte;
    private String id_usario;

    public TusDeportes() {
    }

    public TusDeportes(Avances avance, String id_usario, Deportes deporte) {
        this.avance = avance;
        this.deporte = deporte;
        this.id_usario = id_usario;
    }

    public Avances getAvance() {
        return avance;
    }

    public void setAvance(Avances avance) {
        this.avance = avance;
    }

    public Deportes getDeporte() {
        return deporte;
    }

    public void setDeporte(Deportes deporte) {
        this.deporte = deporte;
    }

    public String getId_usario() {
        return id_usario;
    }

    public void setId_usario(String id_usario) {
        this.id_usario = id_usario;
    }
}
