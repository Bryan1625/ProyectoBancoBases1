package com.example.proyectobancobases1.model;

import java.time.LocalDate;

public class Contrato {
    private String numero, descripcion;
    private LocalDate fechaInicio, fechaTerminacion, fecha;
    private Sucursal sucursal;
    private Cargo cargo;
    private Empleado empleado;

    public Contrato(String numero, String descripcion, LocalDate fechaInicio, LocalDate fechaTerminacion, Sucursal sucursal, Cargo cargo, Empleado empleado) {
        this.numero = numero;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaTerminacion = fechaTerminacion;
        this.fecha = LocalDate.now();
        this.sucursal = sucursal;
        this.cargo = cargo;
        this.empleado = empleado;
    }

    public Contrato() {
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaTerminacion() {
        return fechaTerminacion;
    }

    public void setFechaTerminacion(LocalDate fechaTerminacion) {
        this.fechaTerminacion = fechaTerminacion;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
