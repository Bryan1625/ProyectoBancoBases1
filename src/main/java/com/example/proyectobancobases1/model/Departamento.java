package com.example.proyectobancobases1.model;

public class Departamento {
    private String codigo, nombre;
    private Municipio municipio;

    public Departamento(String codigo, String nombre, Municipio municipio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.municipio = municipio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Municipio getMunicipio() {
        return municipio;
    }

    public void setMunicipio(Municipio municipio) {
        this.municipio = municipio;
    }
}
