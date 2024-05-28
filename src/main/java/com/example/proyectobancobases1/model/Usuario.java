package com.example.proyectobancobases1.model;

import java.time.LocalDate;

public class Usuario {
    private String usuario,contrasenia;
    private Empleado empleado;
    private LocalDate fechaCreacion;

    public Usuario(String usuario, String contrasenia, Empleado empleado) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.empleado = empleado;
        this.fechaCreacion = LocalDate.now();
    }

    public Usuario() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
