package com.example.proyectobancobases1.model;

public class Usuario {
    private String usuario,contrasenia;
    private Empleado empleado;

    public Usuario(String usuario, String contrasenia, Empleado empleado) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.empleado = empleado;
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
