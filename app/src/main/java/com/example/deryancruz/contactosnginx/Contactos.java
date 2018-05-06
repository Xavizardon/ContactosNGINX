package com.example.deryancruz.contactosnginx;

/**
 * Created by Deryan Cruz on 5/6/2018.
 */

public class Contactos {
    private String NombreContacto;
    private String TelefonoContacto;
    private String CorreContacto;
    private int fotoContacto;

    //Creando Constructor
    public Contactos(String nombre, String telefono, String correo, int foto) {
        this.NombreContacto = nombre;
        this.TelefonoContacto = telefono;
        this.CorreContacto = correo;
        this.fotoContacto = foto;
    }

    public Contactos() {
    }

    //Creando setters
    public void setNombreContacto(String nombre) {
        NombreContacto = nombre;
    }

    public void setTelefonoContacto(String telefono) {
        TelefonoContacto = telefono;
    }

    public void setCorreContacto(String correo) {
        CorreContacto = correo;
    }

    public void setFotoContacto(int foto) {
        fotoContacto = foto;
    }



    //Creando Getters
    public String getNombreContacto() {
        return NombreContacto;
    }

    public String getTelefonoContacto() {
        return TelefonoContacto;
    }

    public String getCorreContacto() {
        return CorreContacto;
    }

    public int getFotoContacto() {
        return fotoContacto;
    }
}
