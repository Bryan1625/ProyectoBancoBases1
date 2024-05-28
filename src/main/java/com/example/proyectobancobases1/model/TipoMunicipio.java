package com.example.proyectobancobases1.model;

public class TipoMunicipio {
    private String nombre;
    private String codigo;

    public TipoMunicipio(String codigo, String nombre) {
        this.nombre = nombre;
        this.codigo = codigo;
    }
    public TipoMunicipio(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
