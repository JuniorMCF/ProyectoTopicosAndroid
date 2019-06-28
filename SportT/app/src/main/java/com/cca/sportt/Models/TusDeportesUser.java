package com.cca.sportt.Models;

public class TusDeportesUser {
    private String nameDeporte;
    private String urlFotoDeporte;

    public TusDeportesUser() {
    }

    public TusDeportesUser(String nameDeporte, String urlFotoDeporte) {
        this.nameDeporte = nameDeporte;
        this.urlFotoDeporte = urlFotoDeporte;
    }

    public String getNameDeporte() {
        return nameDeporte;
    }

    public void setNameDeporte(String nameDeporte) {
        this.nameDeporte = nameDeporte;
    }

    public String getUrlFotoDeporte() {
        return urlFotoDeporte;
    }

    public void setUrlFotoDeporte(String urlFotoDeporte) {
        this.urlFotoDeporte = urlFotoDeporte;
    }
}
