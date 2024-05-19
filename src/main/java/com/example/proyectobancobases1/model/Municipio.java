package com.example.proyectobancobases1.model;

public class Municipio {
    private String codigo,nombre,poblacion,tipoMunicipio;
    private Departamento departamento;

    public Municipio(String codigo, String nombre, String poblacion, String tipoMunicipio, Departamento departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.tipoMunicipio = tipoMunicipio;
        this.departamento = departamento;
    }

    public Municipio() {
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
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

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getTipoMunicipio() {
        return tipoMunicipio;
    }

    public void setTipoMunicipio(String tipoMunicipio) {
        this.tipoMunicipio = tipoMunicipio;
    }
}
