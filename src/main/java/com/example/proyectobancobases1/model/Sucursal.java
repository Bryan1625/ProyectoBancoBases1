package com.example.proyectobancobases1.model;

public class Sucursal {
    private String codigo,nombre;
    private Municipio municipio;
    private Departamento departamento;
    private double presupuestoAnual;

    public Sucursal(String codigo, String nombre, Municipio municipio, Departamento departamento, double presupuestoAnual) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.municipio = municipio;
        this.departamento = departamento;
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

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(double presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }
}
