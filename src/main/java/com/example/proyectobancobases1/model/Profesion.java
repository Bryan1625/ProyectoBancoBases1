package com.example.proyectobancobases1.model;

public class Profesion {
    private String codigo;
    private String nombre;

    public Profesion(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    public Profesion(){

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
}
