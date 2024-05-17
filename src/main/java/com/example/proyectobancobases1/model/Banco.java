package com.example.proyectobancobases1.model;

import java.util.ArrayList;

public class Banco {
    private ArrayList<Cargo> cargos;
    private ArrayList<Contrato> contratos;
    private ArrayList<Departamento> departamentosConSede;
    private ArrayList<Municipio> municipiosConSede;
    private ArrayList<Empleado> empleados;
    private ArrayList<Sucursal> sucursales;
    private ArrayList<String> tiposMunicipios;
    private ArrayList<Usuario> usuarios;

    public Banco() {
        this.cargos = new ArrayList<>();
        this.contratos = new ArrayList<>();
        this.departamentosConSede = new ArrayList<>();
        this.municipiosConSede = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.sucursales = new ArrayList<>();
        this.tiposMunicipios = new ArrayList<>();
        this.usuarios = new ArrayList<>();
    }

    public void agregarCargo(Cargo cargo) {
        cargos.add(cargo);
    }

    public void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public void agregarDepartamentoConSede(Departamento departamento) {
        departamentosConSede.add(departamento);
    }

    public void agregarMunicipioConSede(Municipio municipio) {
        municipiosConSede.add(municipio);
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void agregarSucursal(Sucursal sucursal) {
        sucursales.add(sucursal);
    }

    public void agregarTipoMunicipio(String tipoMunicipio) {
        tiposMunicipios.add(tipoMunicipio);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    public void eliminarCargo(Cargo cargo) {
        cargos.remove(cargo);
    }

    public void eliminarContrato(Contrato contrato) {
        contratos.remove(contrato);
    }

    public void eliminarDepartamentoConSede(Departamento departamento) {
        departamentosConSede.remove(departamento);
    }

    public void eliminarMunicipioConSede(Municipio municipio) {
        municipiosConSede.remove(municipio);
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }

    public void eliminarSucursal(Sucursal sucursal) {
        sucursales.remove(sucursal);
    }

    public void eliminarTipoMunicipio(String tipoMunicipio) {
        tiposMunicipios.remove(tipoMunicipio);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public ArrayList<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(ArrayList<Cargo> cargos) {
        this.cargos = cargos;
    }

    public ArrayList<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(ArrayList<Contrato> contratos) {
        this.contratos = contratos;
    }

    public ArrayList<Departamento> getDepartamentosConSede() {
        return departamentosConSede;
    }

    public void setDepartamentosConSede(ArrayList<Departamento> departamentosConSede) {
        this.departamentosConSede = departamentosConSede;
    }

    public ArrayList<Municipio> getMunicipiosConSede() {
        return municipiosConSede;
    }

    public void setMunicipiosConSede(ArrayList<Municipio> municipiosConSede) {
        this.municipiosConSede = municipiosConSede;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public ArrayList<String> getTiposMunicipios() {
        return tiposMunicipios;
    }

    public void setTiposMunicipios(ArrayList<String> tiposMunicipios) {
        this.tiposMunicipios = tiposMunicipios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
