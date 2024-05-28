package com.example.proyectobancobases1.model;

public class Usuario {
    private String usuario,contrasenia;
    private String empleado;

    public Usuario(String usuario, String contrasenia, String empleado) {
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

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
}
