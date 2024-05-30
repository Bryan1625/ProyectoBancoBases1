package com.example.proyectobancobases1.model;

public class Municipio {
    private String codigo,nombre;
    private TipoMunicipio tipoMunicipio;
    private double poblacion;
    private String departamento;

    public Municipio(String codigo, String nombre, double poblacion, TipoMunicipio tipoMunicipio, String departamento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.poblacion = poblacion;
        this.tipoMunicipio = tipoMunicipio;
        this.departamento = departamento;
    }

    public Municipio() {
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
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

    public double getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(double poblacion) {
        this.poblacion = poblacion;
    }

    public TipoMunicipio getTipoMunicipio() {
        return tipoMunicipio;
    }

    public void setTipoMunicipio(TipoMunicipio tipoMunicipio) {
        this.tipoMunicipio = tipoMunicipio;
    }
}
