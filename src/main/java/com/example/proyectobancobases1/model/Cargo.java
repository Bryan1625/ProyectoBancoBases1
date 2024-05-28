package com.example.proyectobancobases1.model;

public class Cargo {
    private String codigo, nombre;
    private double salario;
    private String nivelUsuario;

    public Cargo(String codigo, String nombre, double salario, String nivelUsuario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.salario = salario;
        this.nivelUsuario = nivelUsuario;
    }

    public Cargo() {
    }

    public String getNivelUsuario() {
        return nivelUsuario;
    }

    public void setNivelUsuario(String nivelUsuario) {
        this.nivelUsuario = nivelUsuario;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
