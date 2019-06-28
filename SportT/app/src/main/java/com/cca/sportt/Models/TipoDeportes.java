package com.cca.sportt.Models;

public class TipoDeportes {
    private String tipoDeporte;
    private String urlTipoDeporte;

    public TipoDeportes() {
    }

    public TipoDeportes(String tipoDeporte, String urlTipoDeporte) {
        this.tipoDeporte = tipoDeporte;
        this.urlTipoDeporte = urlTipoDeporte;
    }

    public String getTipoDeporte() {
        return tipoDeporte;
    }

    public void setTipoDeporte(String tipoDeporte) {
        this.tipoDeporte = tipoDeporte;
    }

    public String getUrlTipoDeporte() {
        return urlTipoDeporte;
    }

    public void setUrlTipoDeporte(String urlTipoDeporte) {
        this.urlTipoDeporte = urlTipoDeporte;
    }
}
