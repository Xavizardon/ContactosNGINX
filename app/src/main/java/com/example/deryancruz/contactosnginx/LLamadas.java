package com.example.deryancruz.contactosnginx;

public class LLamadas {
    private String NombreLlamada;
    private String TelefofonoLlamada;
    private String TipoLlamada;
    private String DuracionLlamada;

    public LLamadas(String nombreLlamada, String telefofonoLlamada, String tipoLlamada, String duracionLlamada) {
        NombreLlamada = nombreLlamada;
        TelefofonoLlamada = telefofonoLlamada;
        TipoLlamada = tipoLlamada;
        DuracionLlamada = duracionLlamada;
    }

    public String getNombreLlamada() {
        return NombreLlamada;
    }

    public void setNombreLlamada(String nombreLlamada) {
        NombreLlamada = nombreLlamada;
    }

    public String getTelefofonoLlamada() {
        return TelefofonoLlamada;
    }

    public void setTelefofonoLlamada(String telefofonoLlamada) {
        TelefofonoLlamada = telefofonoLlamada;
    }

    public String getTipoLlamada() {
        return TipoLlamada;
    }

    public void setTipoLlamada(String tipoLlamada) {
        TipoLlamada = tipoLlamada;
    }

    public String getDuracionLlamada() {
        return DuracionLlamada;
    }

    public void setDuracionLlamada(String duracionLlamada) {
        DuracionLlamada = duracionLlamada;
    }
}
