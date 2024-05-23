package com.example.proyectobancobases1.model;

import java.util.ArrayList;
import com.example.proyectobancobases1.util.BaseDeDatosUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Banco {
    private ArrayList<Cargo> cargos;
    private ArrayList<Contrato> contratos;
    private ArrayList<Departamento> departamentosConSede;
    private ArrayList<Municipio> municipiosConSede;
    private ArrayList<Empleado> empleados;
    private ArrayList<Sucursal> sucursales;
    private ArrayList<TipoMunicipio> tiposMunicipios;
    private ArrayList<Usuario> usuarios;
    private ArrayList<Profesion> profesiones;

    public Banco() {
        this.cargos = new ArrayList<>();
        this.contratos = new ArrayList<>();
        this.departamentosConSede = new ArrayList<>();
        this.municipiosConSede = new ArrayList<>();
        this.empleados = new ArrayList<>();
        this.sucursales = new ArrayList<>();
        this.tiposMunicipios = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.profesiones = new ArrayList<>();
    }

    public ArrayList<Profesion> getProfesiones() {
        return profesiones;
    }

    public void setProfesiones(ArrayList<Profesion> profesiones) {
        this.profesiones = profesiones;
    }

    public void agregarCargo(Cargo cargo) {
        cargos.add(cargo);
        agregarCargoDataBase(cargo);
    }

    public void agregarCargoDataBase(Cargo cargo) {
        String sql = "INSERT INTO TCargo (CCodigo, CNombre, CSalario) VALUES (?, ?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setString(1, cargo.getCodigo());
            declaracion.setString(2, cargo.getNombre());
            declaracion.setDouble(3, cargo.getSalario());
            declaracion.executeUpdate();
            cargos.add(cargo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCargoDataBase(Cargo cargo) {
        String sql = "DELETE FROM TCargo WHERE CCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setString(1, cargo.getCodigo());
            declaracion.executeUpdate();
            cargos.remove(cargo);
        } catch (SQLException e) {
            e.printStackTrace();
        }
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

    public void agregarTipoMunicipio(TipoMunicipio tipoMunicipio) {
        tiposMunicipios.add(tipoMunicipio);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void eliminarCargo(Cargo cargo) {
        cargos.remove(cargo);
        eliminarCargoDataBase(cargo);
    }
    public void eliminarCargoConCodigo(String codigo) {
        Cargo cargo = buscarCargo(codigo);
        if(cargo != null){
            eliminarCargo(cargo);
        }
    }

    public void eliminarContrato(Contrato contrato) {
        contratos.remove(contrato);
    }
    public void eliminarContratoConCodigo(String codigo) {
        Contrato contrato = buscarContrato(codigo);
        if(contrato != null){
            eliminarContrato(contrato);
        }
    }

    public void eliminarDepartamentoConSede(Departamento departamento) {
        departamentosConSede.remove(departamento);
    }
    public void eliminarDepartamentoConSedeConCodigo(String codigo) {
        Departamento departamento = buscarDepartamentoConSede(codigo);
        if(departamento != null){
            eliminarDepartamentoConSede(departamento);
        }
    }
    public void eliminarMunicipioConSede(Municipio municipio) {
        municipiosConSede.remove(municipio);
    }
    public void eliminarMunicipioConSedeConCodigo(String codigo) {
        Municipio municipio = buscarMunicipio(codigo);
        if(municipio != null){
            eliminarMunicipioConSede(municipio);
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleados.remove(empleado);
    }
    public void eliminarEmpleadoConCodigo(String codigo) {
        Empleado empleado = buscarEmpleado(codigo);
        if(empleado != null){
            eliminarEmpleado(empleado);
        }
    }

    public void eliminarSucursal(Sucursal sucursal) {
        sucursales.remove(sucursal);
    }
    public void eliminarSucursalConCodigo(String codigo) {
        Sucursal sucursal = buscarSucursal(codigo);
        if(sucursal != null){
            eliminarSucursal(sucursal);
        }
    }

    public void eliminarTipoMunicipio(TipoMunicipio tipoMunicipio) {
        tiposMunicipios.remove(tipoMunicipio);
    }
    public void eliminarTipoMunicipioConCodigo(String codigo) {
        TipoMunicipio tipoMunicipio = buscarTipoMunicipio(codigo);
        if(tipoMunicipio != null){
            eliminarTipoMunicipio(tipoMunicipio);
        }
    }

    public void actualizarDepartamentoConSede(Departamento departamento, Departamento nuevo){
        departamento = nuevo;
    }

    public Departamento buscarDepartamentoConSede(String codigo){
        boolean encontrado = false;
        Departamento buscado = null;
        for (int i = 0; i < departamentosConSede.size() && !encontrado; i++) {
            if (departamentosConSede.get(i).getCodigo().contentEquals(codigo)) {
                encontrado = true;
                buscado = departamentosConSede.get(i);
            }
        }
        return buscado;
    }

    public void actualizarTipoMunicipio(TipoMunicipio tipoMunicipio, TipoMunicipio nuevo) {
        tipoMunicipio = nuevo;
    }

    public TipoMunicipio buscarTipoMunicipio(String codigo) {
        boolean encontrado = false;
        TipoMunicipio buscado = null;
        for (int i = 0; i < tiposMunicipios.size() && !encontrado; i++) {
            if (tiposMunicipios.get(i).getCodigo().contentEquals(codigo)) {
                encontrado = true;
                buscado = tiposMunicipios.get(i);
            }
        }
        return buscado;
    }

    public void actualizarMunicipio(Municipio municipio, Municipio nuevo) {
        municipio = nuevo;
    }

    public Municipio buscarMunicipio(String codigo) {
        boolean encontrado = false;
        Municipio buscado = null;
        for (int i = 0; i < municipiosConSede.size() && !encontrado; i++) {
            if (municipiosConSede.get(i).getCodigo().contentEquals(codigo)) {
                encontrado = true;
                buscado = municipiosConSede.get(i);
            }
        }
        return buscado;
    }

    public void actualizarSucursal(Sucursal sucursal, Sucursal nuevo) {
        sucursal = nuevo;
    }

    public Sucursal buscarSucursal(String codigo) {
        boolean encontrado = false;
        Sucursal buscado = null;
        for (int i = 0; i < sucursales.size() && !encontrado; i++) {
            if (sucursales.get(i).getCodigo().contentEquals(codigo)) {
                encontrado = true;
                buscado = sucursales.get(i);
            }
        }
        return buscado;
    }

    public void actualizarCargo(Cargo cargo, Cargo nuevo) {
        cargo = nuevo;
    }

    public Cargo buscarCargo(String codigo) {
        boolean encontrado = false;
        Cargo buscado = null;
        for (int i = 0; i < cargos.size() && !encontrado; i++) {
            if (cargos.get(i).getCodigo().contentEquals(codigo)) {
                encontrado = true;
                buscado = cargos.get(i);
            }
        }
        return buscado;
    }

    public void actualizarProfesion(Profesion profesion, Profesion nuevo) {
        profesion = nuevo;
    }

    public Profesion buscarProfesion(String codigo) {
        boolean encontrado = false;
        Profesion buscado = null;
        for (int i = 0; i <profesiones.size() && !encontrado; i++) {
            if(profesiones.get(i).getCodigo().contentEquals(codigo)){
                encontrado = true;
                buscado = profesiones.get(i);
            }
        }
        return buscado;
    }

    public void actualizarEmpleado(Empleado empleado, Empleado nuevo){
        empleado = nuevo;
    }

    public Empleado buscarEmpleado(String codigo){
        boolean encontrado = false;
        Empleado buscado = null;
        for (int i = 0; i < empleados.size() && !encontrado; i++) {
            if(empleados.get(i).getCodigo().contentEquals(codigo)){
                encontrado = true;
                buscado = empleados.get(i);
            }
        }
        return buscado;
    }

    public void actualizarContrato(Contrato contrato, Contrato nuevo) {
        contrato = nuevo;
    }

    public Contrato buscarContrato(String codigo) {
        boolean encontrado = false;
        Contrato buscado = null;
        for (int i = 0; i < contratos.size() && !encontrado; i++) {
            if (contratos.get(i).getCodigo().contentEquals(codigo)) {
                encontrado = true;
                buscado = contratos.get(i);
            }
        }
        return buscado;
    }

    public void actualizarUsuario(Usuario usuario, Usuario nuevo) {
        usuario.setUsuario(nuevo.getUsuario());
        usuario.setContrasenia(nuevo.getContrasenia());
    }

    public Usuario buscarUsuario(String usuario) {
        boolean encontrado = false;
        Usuario buscado = null;
        for (int i = 0; i < usuarios.size() && !encontrado; i++) {
            if (usuarios.get(i).getUsuario().contentEquals(usuario)) {
                encontrado = true;
                buscado = usuarios.get(i);
            }
        }
        return buscado;
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }
    public void eliminarUsuarioConNombre(String nombre) {
        Usuario usuario = buscarUsuario(nombre);
        if(usuario != null){
            eliminarUsuario(usuario);
        }
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

    public ArrayList<TipoMunicipio> getTiposMunicipios() {
        return tiposMunicipios;
    }

    public void setTiposMunicipios(ArrayList<TipoMunicipio> tiposMunicipios) {
        this.tiposMunicipios = tiposMunicipios;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void agregarProfesion(Profesion profesion){
        profesiones.add(profesion);
    }

    public void eliminarProfesion(Profesion profesion){
        profesiones.remove(profesion);
    }
    public void eliminarProfesionConCodigo(String codigo){
        Profesion profesion = buscarProfesion(codigo);
        if(profesion != null){
            eliminarProfesion(profesion);
        }
    }
}
