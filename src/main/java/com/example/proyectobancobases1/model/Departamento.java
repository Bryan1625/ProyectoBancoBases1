package com.example.proyectobancobases1.model;

import java.util.ArrayList;

public class Departamento {
    private String codigo, nombre;
    private ArrayList<Municipio> municipios;

    public Departamento(String codigo, String nombre, ArrayList<Municipio> municipios) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.municipios = municipios;
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

    public ArrayList<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(ArrayList<Municipio> municipios) {
        this.municipios = municipios;
    }
}
