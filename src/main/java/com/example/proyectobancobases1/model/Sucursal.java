package com.example.proyectobancobases1.model;

public class Sucursal {
    private String codigo,nombre;
    private String municipio;
    private String departamento;
    private int presupuestoAnual;

    public Sucursal(String codigo, String nombre, String municipio, String departamento, int presupuestoAnual) {
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

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public double getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(int presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }
}
