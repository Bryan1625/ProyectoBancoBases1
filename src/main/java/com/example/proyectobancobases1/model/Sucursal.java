package com.example.proyectobancobases1.model;

public class Sucursal {
    private String codigo,nombre;
    private Municipio municipio;
    private Empleado director;
    private double presupuestoAnual;

    public Sucursal(String codigo, String nombre, Municipio municipio, Empleado director, double presupuestoAnual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.municipio = municipio;
        this.director = director;
        this.presupuestoAnual = presupuestoAnual;
    }

    public Sucursal() {
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

    public Empleado getDirector() {
        return director;
    }

    public void setDirector(Empleado director) {
        this.director = director;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }
}
