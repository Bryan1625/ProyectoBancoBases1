package com.example.proyectobancobases1.model;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.example.proyectobancobases1.util.BaseDeDatosUtil;

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
        inicializarDatosBanco();
    }

    public void inicializarDatosBanco(){
        try {
            // Prueba con Departamento
            Departamento nuevoDepartamento = new Departamento("09", "NuevoDepartamento", 123);
            agregarDepartamentoConSede(nuevoDepartamento);

            // Prueba con Departamento
            Cargo nuevoCargo = new Cargo("9", "NuevoCargo", 123, "1");
            agregarCargo(nuevoCargo);

            // Prueba con TipoMunicipio
            TipoMunicipio nuevoTipoMunicipio = new TipoMunicipio("9", "Rural");
            agregarTipoMunicipio(nuevoTipoMunicipio);

            // Prueba con Municipio
            Municipio nuevoMunicipio = new Municipio("009", "NuevoMunicipio", 123, nuevoTipoMunicipio, nuevoDepartamento.getNombre());
            agregarMunicipioConSede(nuevoMunicipio);

            // Prueba con Profesion
            Profesion nuevaProfesion = new Profesion("9", "Ingeniero");
            agregarProfesion(nuevaProfesion);

            // Prueba con Sucursal
            Sucursal nuevaSucursal = new Sucursal("009", "NuevaSucursal", nuevoMunicipio, nuevoDepartamento, 12345);
            agregarSucursal(nuevaSucursal);

            // Prueba con Empleado
            Empleado nuevoEmpleado = new Empleado("9", "123456789", "Juan Pérez", "Cra E", "1234567890", "M", LocalDate.of(1990, 1, 1), nuevaProfesion);
            agregarEmpleado(nuevoEmpleado);

            // Prueba con Contrato
            Contrato nuevoContrato = new Contrato("007", "Contrato de prueba", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), nuevaSucursal, nuevoCargo, nuevoEmpleado);
            agregarContrato(nuevoContrato);


            inicializarCargos(BaseDeDatosUtil.obtenerConexion());
            inicializarContratos(BaseDeDatosUtil.obtenerConexion());
            inicializarDepartamentos(BaseDeDatosUtil.obtenerConexion());
            inicializarMunicipios(BaseDeDatosUtil.obtenerConexion());
            inicializarEmpleados(BaseDeDatosUtil.obtenerConexion());
            inicializarProfesiones(BaseDeDatosUtil.obtenerConexion());
            inicializarSucursales(BaseDeDatosUtil.obtenerConexion());
            inicializarTiposMunicipios(BaseDeDatosUtil.obtenerConexion());
            inicializarUsuarios(BaseDeDatosUtil.obtenerConexion());

            for (Empleado empleado : empleados) {
                System.out.println(empleado.getNombre());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void inicializarCargos(Connection conexion) {
        String query = "SELECT * FROM TCargo";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Cargo cargo = new Cargo();
                cargo.setCodigo(resultSet.getString("CCodigo"));
                cargo.setNombre(resultSet.getString("CNombre"));
                cargo.setSalario(resultSet.getDouble("CSalario"));
                this.cargos.add(cargo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void inicializarContratos(Connection conexion) {
        String query = "SELECT * FROM TContrato";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Contrato contrato = new Contrato();
                contrato.setNumero(resultSet.getString("CNumero"));
                // Establecer los demás atributos...
                this.contratos.add(contrato);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar los datos de la tabla Departamento
    public void inicializarDepartamentos(Connection conexion) {
        String query = "SELECT * FROM TDepto";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Departamento departamento = new Departamento();
                departamento.setCodigo(resultSet.getString("DCodigo"));
                // Establecer los demás atributos...
                this.departamentosConSede.add(departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar los datos de la tabla Municipio
    public void inicializarMunicipios(Connection conexion) {
        String query = "SELECT * FROM TMunicipio";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Municipio municipio = new Municipio();
                municipio.setCodigo(resultSet.getString("MCodigo"));
                // Establecer los demás atributos...
                this.municipiosConSede.add(municipio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar los datos de la tabla Empleado
    public void inicializarEmpleados(Connection conexion) {
        String query = "SELECT * FROM TEmpleado";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Empleado empleado = new Empleado();
                empleado.setCodigo(resultSet.getString("ECodigo"));
                empleado.setNombre(resultSet.getString("ENombre"));
                empleado.setCedula(resultSet.getString("ECedula"));
                empleado.setContrato(buscarContrato(resultSet.getString("EContrato")));
                empleado.setDireccion(resultSet.getString("EDireccion"));
                empleado.setGenero(resultSet.getString("EGenero"));
                empleado.setTelefono(resultSet.getString("ETelefono"));
                empleado.setFechaNacimiento(resultSet.getDate("EFechaNto").toLocalDate());
                this.empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar los datos de la tabla Sucursal
    public void inicializarSucursales(Connection conexion) {
        String query = "SELECT * FROM TSucursal";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Sucursal sucursal = new Sucursal();
                sucursal.setCodigo(resultSet.getString("SCodigo"));
                // Establecer los demás atributos...
                this.sucursales.add(sucursal);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar los datos de la tabla TipoMunicipio
    public void inicializarTiposMunicipios(Connection conexion) {
        String query = "SELECT * FROM TTipoMunicipio";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                TipoMunicipio tipoMunicipio = new TipoMunicipio();
                tipoMunicipio.setCodigo(resultSet.getString("TMCodigo"));
                // Establecer los demás atributos...
                this.tiposMunicipios.add(tipoMunicipio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar los datos de la tabla Usuario
    public void inicializarUsuarios(Connection conexion) {
        String query = "SELECT * FROM TUsuario";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setUsuario(resultSet.getString("ULogin"));
                // Establecer los demás atributos...
                this.usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para inicializar los datos de la tabla Profesion
    public void inicializarProfesiones(Connection conexion) {
        String query = "SELECT * FROM TProfesion";
        try (Statement statement = conexion.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            while (resultSet.next()) {
                Profesion profesion = new Profesion();
                profesion.setCodigo(resultSet.getString("PCodigo"));
                // Establecer los demás atributos...
                this.profesiones.add(profesion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
    }


//    public static void main(String[] args) {
//        Banco banco = new Banco();
//
//
//        // Prueba con Departamento
//        Departamento nuevoDepartamento = new Departamento("09", "NuevoDepartamento", 123);
//        banco.agregarDepartamentoConSede(nuevoDepartamento);
//        banco.eliminarDepartamentoConSede(nuevoDepartamento);
//
//        // Prueba con Departamento
//        Cargo nuevoCargo = new Cargo("9", "NuevoCargo", 123, "1");
//        banco.agregarCargo(nuevoCargo);
//        banco.eliminarCargo(nuevoCargo);
//
//        // Prueba con TipoMunicipio
//        TipoMunicipio nuevoTipoMunicipio = new TipoMunicipio("9", "Rural");
//        banco.agregarTipoMunicipio(nuevoTipoMunicipio);
//        banco.eliminarTipoMunicipio(nuevoTipoMunicipio);
//
//        // Prueba con Municipio
//        Municipio nuevoMunicipio = new Municipio("009", "NuevoMunicipio", 123, nuevoTipoMunicipio, nuevoDepartamento.getNombre());
//        banco.agregarMunicipioConSede(nuevoMunicipio);
//        banco.eliminarMunicipioConSede(nuevoMunicipio);
//
//        // Prueba con Profesion
//        Profesion nuevaProfesion = new Profesion("9", "Ingeniero");
//        banco.agregarProfesion(nuevaProfesion);
//        banco.eliminarProfesion(nuevaProfesion);
//
//        // Prueba con Sucursal
//        Sucursal nuevaSucursal = new Sucursal("009", "NuevaSucursal", nuevoMunicipio, nuevoDepartamento, 12345);
//        banco.agregarSucursal(nuevaSucursal);
//        banco.eliminarSucursal(nuevaSucursal);
//
//        // Prueba con Empleado
//        Empleado nuevoEmpleado = new Empleado("9", "123456789", "Juan Pérez", "Cra E", "1234567890", "M", LocalDate.of(1990, 1, 1), nuevaProfesion);
//        banco.agregarEmpleado(nuevoEmpleado);
//        banco.eliminarEmpleado(nuevoEmpleado);
//
//        // Prueba con Contrato
//        Contrato nuevoContrato = new Contrato("007", "Contrato de prueba", LocalDate.of(2024, 1, 1), LocalDate.of(2024, 12, 31), nuevaSucursal, nuevoCargo, nuevoEmpleado);
//        banco.agregarContrato(nuevoContrato);
//        banco.eliminarContrato(nuevoContrato);
//
//    }

//    public static void main(String[] args) {
//        Banco banco = new Banco();
//        BaseDeDatosUtil.generarReporteEmpleadosPorSucursal(banco, "Norte");
//    }


    ///////////////////CONSULTAS PEDIDAS QUE DEBE HACER LA APP///////////////////////
    /*
    EN ESTA SECCION SE HARAN LAS CONSULTAS (6), PEDIDAS POR EL PROFESOR
     */
    public List<Empleado> obtenerEmpleadosPorSucursal(String nombreSucursal) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT E.* " +
                "FROM TEmpleado E " +
                "JOIN TSucursal S ON E.ECodigo = S.SCodigo " +
                "WHERE S.SNombre = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setString(1, nombreSucursal);
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                // Aquí debes crear un objeto Empleado y agregarlo a la lista
                Empleado empleado = new Empleado(/* pasar los valores del resultado */);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public List<Empleado> obtenerEmpleadosPorProfesion(String nombreProfesion) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT E.* " +
                "FROM TEmpleado E " +
                "JOIN TProfesion P ON E.EProfesion = P.PCodigo " +
                "WHERE P.PNombre = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setString(1, nombreProfesion);
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                // Aquí debes crear un objeto Empleado y agregarlo a la lista
                Empleado empleado = new Empleado(/* pasar los valores del resultado */);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public List<Empleado> obtenerEmpleadosPorSucursalYProfesion(String nombreSucursal, String nombreProfesion) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT E.* " +
                "FROM TEmpleado E " +
                "JOIN TSucursal S ON E.ECodigo = S.SCodigo " +
                "JOIN TProfesion P ON E.EProfesion = P.PCodigo " +
                "WHERE S.SNombre = ? AND P.PNombre = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setString(1, nombreSucursal);
            declaracion.setString(2, nombreProfesion);
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                // Crear objeto Empleado y agregarlo a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public List<Empleado> obtenerEmpleadosPorSucursalYGenero(String nombreSucursal, String genero) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT E.* " +
                "FROM TEmpleado E " +
                "JOIN TSucursal S ON E.ECodigo = S.SCodigo " +
                "WHERE S.SNombre = ? AND E.EGenero = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setString(1, nombreSucursal);
            declaracion.setString(2, genero);
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                // Crear objeto Empleado y agregarlo a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public List<Sucursal> obtenerSucursalesConEmpleadoGenero(String genero) {
        List<Sucursal> sucursales = new ArrayList<>();
        String sql = "SELECT DISTINCT S.* " +
                "FROM TSucursal S " +
                "JOIN TEmpleado E ON S.SCodigo = E.ECodigo " +
                "WHERE E.EGenero = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setString(1, genero);
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                // Crear objeto Sucursal y agregarlo a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucursales;
    }

    public List<Sucursal> obtenerSucursalesSinEmpleados() {
        List<Sucursal> sucursales = new ArrayList<>();
        String sql = "SELECT S.* " +
                "FROM TSucursal S " +
                "LEFT JOIN TEmpleado E ON S.SCodigo = E.ECodigo " +
                "WHERE E.ECodigo IS NULL";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             Statement declaracion = conexion.createStatement();
             ResultSet resultado = declaracion.executeQuery(sql)) {
            while (resultado.next()) {
                // Crear objeto Sucursal y agregarlo a la lista
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sucursales;
    }

    public List<Empleado> obtenerEmpleadosPorEdadMayorA(int edad) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT E.* " +
                "FROM TEmpleado E " +
                "WHERE YEAR(CURRENT_DATE) - YEAR(E.EFechaNto) > ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setInt(1, edad);
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                String codigo = resultado.getString("ECodigo");
                String cedula = resultado.getString("ECedula");
                String nombre = resultado.getString("ENombre");
                String direccion = resultado.getString("EDireccion");
                String telefono = resultado.getString("ETelefono");
                String genero = resultado.getString("EGenero");
                LocalDate fechaNacimiento = resultado.getDate("EFechaNto").toLocalDate();
                Profesion profesion = new Profesion(resultado.getString("EProfesion"), buscarProfesion(resultado.getString("EProfesion")).getNombre());
                Empleado empleado = new Empleado(codigo, cedula, nombre, direccion, telefono, genero, fechaNacimiento, profesion);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }

    public List<Empleado> obtenerEmpleadosPorEdadMenorA(int edad) {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT E.* " +
                "FROM TEmpleado E " +
                "WHERE YEAR(CURRENT_DATE) - YEAR(E.EFechaNto) < ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {
            declaracion.setInt(1, edad);
            ResultSet resultado = declaracion.executeQuery();
            while (resultado.next()) {
                String codigo = resultado.getString("ECodigo");
                String cedula = resultado.getString("ECedula");
                String nombre = resultado.getString("ENombre");
                String direccion = resultado.getString("EDireccion");
                String telefono = resultado.getString("ETelefono");
                String genero = resultado.getString("EGenero");
                LocalDate fechaNacimiento = resultado.getDate("EFechaNto").toLocalDate();
                Profesion profesion = new Profesion(resultado.getString("EProfesion"), buscarProfesion(resultado.getString("EProfesion")).getNombre());
                Empleado empleado = new Empleado(codigo, cedula, nombre, direccion, telefono, genero, fechaNacimiento, profesion);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleados;
    }



    /////////////////////////////////////////////////////////////////////////////////



    ///////////////////////////////////REPORTES/////////////////////////////////////


    ////////////////////////////////////////////////////////////////////////////////

    // Métodos CRUD para Cargo
    public void agregarCargoDataBase(Cargo cargo) {
        String sql = "INSERT INTO TCargo (CCodigo, CNombre, CSalario) VALUES (?, ?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, cargo.getCodigo());
            declaracion.setString(2, cargo.getNombre());
            declaracion.setString(3, ""+cargo.getSalario());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El cargo con código " + cargo.getCodigo() + " ha sido agregado.");
                cargos.add(cargo);
            } else {
                System.out.println("No se pudo agregar el cargo con código " + cargo.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCargoDataBase(Cargo cargo) {
        String sql = "DELETE FROM TCargo WHERE CCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, cargo.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El cargo con código " + cargo.getCodigo() + " ha sido eliminado.");
                cargos.remove(cargo);
            } else {
                System.out.println("No se pudo eliminar el cargo con código " + cargo.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarCargoDataBase(Cargo cargo) {
        String sql = "UPDATE TCargo SET CNombre = ?, CSalario = ? WHERE CCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, cargo.getNombre());
            declaracion.setDouble(2, cargo.getSalario());
            declaracion.setString(3, cargo.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El cargo con código " + cargo.getCodigo() + " ha sido actualizado.");
            } else {
                System.out.println("No se pudo actualizar el cargo con código " + cargo.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarCargo(Cargo cargo) {
        agregarCargoDataBase(cargo);
    }

    public void eliminarCargo(Cargo cargo) {
        eliminarCargoDataBase(cargo);
    }

    public void actualizarCargo(Cargo cargo) {
        actualizarCargoDataBase(cargo);
    }

    public Cargo buscarCargo(String codigo) {
        for (Cargo cargo : cargos) {
            if (cargo.getCodigo().equals(codigo)) {
                return cargo;
            }
        }
        return null;
    }

    public Cargo buscarCargoPorNombre(String nombre) {
        for (Cargo cargo : cargos) {
            if (cargo.getNombre().equals(nombre)) {
                return cargo;
            }
        }
        return null;
    }
    public Municipio buscarMunicipioPorNombre(String nombre) {
        for (Municipio municipio : municipiosConSede) {
            if (municipio.getNombre().equalsIgnoreCase(nombre)) {
                return municipio;
            }
        }
        return null;
    }
    public Profesion buscarProfesionPorNombre(String nombre) {
        for (Profesion profesion : profesiones) {
            if (profesion.getNombre().equalsIgnoreCase(nombre)) {
                return profesion;
            }
        }
        return null;
    }
    public Sucursal buscarSucursalPorNombre(String nombre) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getNombre().equalsIgnoreCase(nombre)) {
                return sucursal;
            }
        }
        return null;
    }
    public TipoMunicipio buscarTipoMunicipioPorNombre(String nombre) {
        for (TipoMunicipio tipoMunicipio : tiposMunicipios) {
            if (tipoMunicipio.getNombre().equalsIgnoreCase(nombre)) {
                return tipoMunicipio;
            }
        }
        return null;
    }
    public Departamento buscarDepartamentoPorNombre(String nombre) {
        for (Departamento departamento : departamentosConSede) {
            if (departamento.getNombre().equalsIgnoreCase(nombre)) {
                return departamento;
            }
        }
        return null;
    }


    public void eliminarCargoConCodigo(String codigo) {
        Cargo cargo = buscarCargo(codigo);
        if (cargo != null) {
            eliminarCargo(cargo);
        } else {
            System.out.println("No se encontró un cargo con el código " + codigo + ".");
        }
    }

    // Métodos CRUD para Contrato
    public void agregarContratoDataBase(Contrato contrato) {
        String sql = "INSERT INTO TContrato (CNumero, CFecha, CFechaInicio, CFechaTerminacion,  CSucursal, CEmpleado, CCargo, CDescripcion) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, contrato.getNumero());
            declaracion.setDate(2, Date.valueOf(contrato.getFecha()));
            declaracion.setDate(3, Date.valueOf(contrato.getFechaInicio()));
            declaracion.setDate(4, Date.valueOf(contrato.getFechaTerminacion()));
            declaracion.setString(5, contrato.getSucursal().getCodigo());
            declaracion.setString(6, contrato.getEmpleado().getCodigo());
            declaracion.setString(7, contrato.getCargo().getCodigo());
            declaracion.setString(8, contrato.getDescripcion());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El contrato con número " + contrato.getNumero() + " ha sido agregado.");
                contratos.add(contrato);
            } else {
                System.out.println("No se pudo agregar el contrato con número " + contrato.getNumero() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarContratoDataBase(Contrato contrato) {
        String sql = "DELETE FROM TContrato WHERE CNumero = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, contrato.getNumero());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El contrato con número " + contrato.getNumero() + " ha sido eliminado.");
                contratos.remove(contrato);
            } else {
                System.out.println("No se pudo eliminar el contrato con número " + contrato.getNumero() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarContratoDataBase(Contrato contrato) {
        String sql = "UPDATE TContrato SET CFecha = ?, CCodigoEmpleado = ?, CCodigoSucursal = ? WHERE CNumero = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setDate(1, Date.valueOf(contrato.getFecha()));
            declaracion.setString(2, contrato.getEmpleado().getCodigo());
            declaracion.setString(3, contrato.getSucursal().getCodigo());
            declaracion.setString(4, contrato.getNumero());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El contrato con número " + contrato.getNumero() + " ha sido actualizado.");
            } else {
                System.out.println("No se pudo actualizar el contrato con número " + contrato.getNumero() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarContrato(Contrato contrato) {
        agregarContratoDataBase(contrato);
    }

    public void eliminarContrato(Contrato contrato) {
        eliminarContratoDataBase(contrato);
    }

    public void actualizarContrato(Contrato contrato) {
        actualizarContratoDataBase(contrato);
    }

    public Contrato buscarContrato(String codigo) {
        for (Contrato contrato : contratos) {
            if (contrato.getNumero().equals(codigo)) {
                return contrato;
            }
        }
        return null;
    }

    public void eliminarContratoConCodigo(String codigo) {
        Contrato contrato = buscarContrato(codigo);
        if (contrato != null) {
            eliminarContrato(contrato);
        } else {
            System.out.println("No se encontró un contrato con el número " + codigo + ".");
        }
    }

    // Métodos CRUD para Departamento
    public void agregarDepartamentoConSedeDataBase(Departamento departamento) {
        String sql = "INSERT INTO TDepto (DCodigo, DNombre) VALUES (?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, departamento.getCodigo());
            declaracion.setString(2, departamento.getNombre());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El departamento con código " + departamento.getCodigo() + " ha sido agregado.");
                departamentosConSede.add(departamento);
            } else {
                System.out.println("No se pudo agregar el departamento con código " + departamento.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarDepartamentoConSedeDataBase(Departamento departamento) {
        String sql = "DELETE FROM TDepto WHERE DCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, departamento.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El departamento con código " + departamento.getCodigo() + " ha sido eliminado.");
                departamentosConSede.remove(departamento);
            } else {
                System.out.println("No se pudo eliminar el departamento con código " + departamento.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarDepartamentoConSedeDataBase(Departamento departamento) {
        String sql = "UPDATE TDepartamento SET DNombre = ? WHERE DCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, departamento.getNombre());
            declaracion.setString(2, departamento.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El departamento con código " + departamento.getCodigo() + " ha sido actualizado.");
            } else {
                System.out.println("No se pudo actualizar el departamento con código " + departamento.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarDepartamentoConSede(Departamento departamento) {
        agregarDepartamentoConSedeDataBase(departamento);
    }

    public void eliminarDepartamentoConSede(Departamento departamento) {
        eliminarDepartamentoConSedeDataBase(departamento);
    }

    public void actualizarDepartamentoConSede(Departamento departamento) {
        actualizarDepartamentoConSedeDataBase(departamento);
    }

    public Departamento buscarDepartamentoConSede(String codigo) {
        for (Departamento departamento : departamentosConSede) {
            if (departamento.getCodigo().equals(codigo)) {
                return departamento;
            }
        }
        return null;
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

    public ArrayList<Profesion> getProfesiones() {
        return profesiones;
    }

    public void setProfesiones(ArrayList<Profesion> profesiones) {
        this.profesiones = profesiones;
    }

    public void eliminarDepartamentoConSedeConCodigo(String codigo) {
        Departamento departamento = buscarDepartamentoConSede(codigo);
        if (departamento != null) {
            eliminarDepartamentoConSede(departamento);
        } else {
            System.out.println("No se encontró un departamento con el código " + codigo + ".");
        }
    }

    // Métodos CRUD para Municipio
    public void agregarMunicipioConSedeDataBase(Municipio municipio) {
        String sql = "INSERT INTO TMunicipio (MCodigo, MNombre) VALUES (?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, municipio.getCodigo());
            declaracion.setString(2, municipio.getNombre());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El municipio con código " + municipio.getCodigo() + " ha sido agregado.");
                municipiosConSede.add(municipio);
            } else {
                System.out.println("No se pudo agregar el municipio con código " + municipio.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarMunicipioConSedeDataBase(Municipio municipio) {
        String sql = "DELETE FROM TMunicipio WHERE MCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, municipio.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El municipio con código " + municipio.getCodigo() + " ha sido eliminado.");
                municipiosConSede.remove(municipio);
            } else {
                System.out.println("No se pudo eliminar el municipio con código " + municipio.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarMunicipioConSedeDataBase(Municipio municipio) {
        String sql = "UPDATE TMunicipio SET MNombre = ? WHERE MCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, municipio.getNombre());
            declaracion.setString(2, municipio.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El municipio con código " + municipio.getCodigo() + " ha sido actualizado.");
            } else {
                System.out.println("No se pudo actualizar el municipio con código " + municipio.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarMunicipioConSede(Municipio municipio) {
        agregarMunicipioConSedeDataBase(municipio);
    }

    public void eliminarMunicipioConSede(Municipio municipio) {
        eliminarMunicipioConSedeDataBase(municipio);
    }

    public void actualizarMunicipioConSede(Municipio municipio) {
        actualizarMunicipioConSedeDataBase(municipio);
    }

    public Municipio buscarMunicipioConSede(String codigo) {
        for (Municipio municipio : municipiosConSede) {
            if (municipio.getCodigo().equals(codigo)) {
                return municipio;
            }
        }
        return null;
    }

    public void eliminarMunicipioConSedeConCodigo(String codigo) {
        Municipio municipio = buscarMunicipioConSede(codigo);
        if (municipio != null) {
            eliminarMunicipioConSede(municipio);
        } else {
            System.out.println("No se encontró un municipio con el código " + codigo + ".");
        }
    }

    public boolean login(String usuario, String contrasenia){
        Usuario login = buscarUsuario(usuario);
        if (login == null) {
            return false;
        }else{
            if(login.getContrasenia().equals(contrasenia)){
                return true;
            }
        }
        return false;
    }

    // Implementa el mismo patrón para las demás entidades: Empleado, Sucursal, TipoMunicipio, Usuario, Profesion
    // A continuación, se proporciona un ejemplo para Empleado:

    // Métodos CRUD para Empleado
    public void agregarEmpleadoDataBase(Empleado empleado) {
        String sql = "INSERT INTO TEmpleado (ECodigo, ECedula, ENombre, ETelefono, EDireccion," +
                "EProfesion, EGenero, EFechaNto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, empleado.getCodigo());
            declaracion.setString(2, empleado.getCedula());
            declaracion.setString(3, empleado.getNombre());
            declaracion.setString(4, empleado.getTelefono());
            declaracion.setString(5, empleado.getDireccion());
            declaracion.setString(6, empleado.getProfesion().getCodigo());
            declaracion.setString(7, empleado.getGenero());
            declaracion.setDate(8, Date.valueOf(empleado.getFechaNacimiento()));
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El empleado con código " + empleado.getCodigo() + " ha sido agregado.");
                empleados.add(empleado);
            } else {
                System.out.println("No se pudo agregar el empleado con código " + empleado.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarEmpleadoDataBase(Empleado empleado) {
        String sql = "DELETE FROM TEmpleado WHERE ECodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, empleado.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El empleado con código " + empleado.getCodigo() + " ha sido eliminado.");
                empleados.remove(empleado);
            } else {
                System.out.println("No se pudo eliminar el empleado con código " + empleado.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarEmpleadoDataBase(Empleado empleado) {
        String sql = "UPDATE TEmpleado SET ECedula = ?, ENombre = ?, ETelefono = ?, EDireccion = ?, EProfesion = ?, EGenero = ?, EFechaNto = ? WHERE ECodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, empleado.getCedula());
            declaracion.setString(2, empleado.getNombre());
            declaracion.setString(3, empleado.getTelefono());
            declaracion.setString(4, empleado.getDireccion());
            declaracion.setString(5, empleado.getProfesion().getCodigo());
            declaracion.setString(6, empleado.getGenero());
            declaracion.setDate(7, Date.valueOf(empleado.getFechaNacimiento()));
            declaracion.setString(8, empleado.getCodigo());

            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El empleado con código " + empleado.getCodigo() + " ha sido actualizado.");
            } else {
                System.out.println("No se pudo actualizar el empleado con código " + empleado.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void agregarEmpleado(Empleado empleado) {
        agregarEmpleadoDataBase(empleado);
    }

    public void eliminarEmpleado(Empleado empleado) {
        eliminarEmpleadoDataBase(empleado);
    }

    public void actualizarEmpleado(Empleado empleado) {
        actualizarEmpleadoDataBase(empleado);
    }

    public Empleado buscarEmpleado(String codigo) {
        for (Empleado empleado : empleados) {
            if (empleado.getCodigo().equals(codigo)) {
                return empleado;
            }
        }
        return null;
    }

    public void eliminarEmpleadoConCodigo(String codigo) {
        Empleado empleado = buscarEmpleado(codigo);
        if (empleado != null) {
            eliminarEmpleado(empleado);
        } else {
            System.out.println("No se encontró un empleado con el código " + codigo + ".");
        }
    }

    // Métodos CRUD para Sucursal
    public void agregarSucursalDataBase(Sucursal sucursal) {
        String sql = "INSERT INTO TSucursal (SCodigo, SNombre) VALUES (?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, sucursal.getCodigo());
            declaracion.setString(2, sucursal.getNombre());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La sucursal con código " + sucursal.getCodigo() + " ha sido agregada.");
                sucursales.add(sucursal);
            } else {
                System.out.println("No se pudo agregar la sucursal con código " + sucursal.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSucursalDataBase(Sucursal sucursal) {
        String sql = "DELETE FROM TSucursal WHERE SCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, sucursal.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La sucursal con código " + sucursal.getCodigo() + " ha sido eliminada.");
                sucursales.remove(sucursal);
            } else {
                System.out.println("No se pudo eliminar la sucursal con código " + sucursal.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarSucursalDataBase(Sucursal sucursal) {
        String sql = "UPDATE TSucursal SET SNombre = ? WHERE SCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, sucursal.getNombre());
            declaracion.setString(2, sucursal.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La sucursal con código " + sucursal.getCodigo() + " ha sido actualizada.");
            } else {
                System.out.println("No se pudo actualizar la sucursal con código " + sucursal.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarSucursal(Sucursal sucursal) {
        agregarSucursalDataBase(sucursal);
    }

    public void eliminarSucursal(Sucursal sucursal) {
        eliminarSucursalDataBase(sucursal);
    }

    public void actualizarSucursal(Sucursal sucursal) {
        actualizarSucursalDataBase(sucursal);
    }

    public Sucursal buscarSucursal(String codigo) {
        for (Sucursal sucursal : sucursales) {
            if (sucursal.getCodigo().equals(codigo)) {
                return sucursal;
            }
        }
        return null;
    }

    public void eliminarSucursalConCodigo(String codigo) {
        Sucursal sucursal = buscarSucursal(codigo);
        if (sucursal != null) {
            eliminarSucursal(sucursal);
        } else {
            System.out.println("No se encontró una sucursal con el código " + codigo + ".");
        }
    }

    // Métodos CRUD para TipoMunicipio
    public void agregarTipoMunicipioDataBase(TipoMunicipio tipoMunicipio) {
        String sql = "INSERT INTO TTipoMunicipio (TMCodigo, TMNombre) VALUES (?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, tipoMunicipio.getCodigo());
            declaracion.setString(2, tipoMunicipio.getNombre());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El tipo de municipio con código " + tipoMunicipio.getCodigo() + " ha sido agregado.");
                tiposMunicipios.add(tipoMunicipio);
            } else {
                System.out.println("No se pudo agregar el tipo de municipio con código " + tipoMunicipio.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarTipoMunicipioDataBase(TipoMunicipio tipoMunicipio) {
        String sql = "DELETE FROM TTipoMunicipio WHERE TMCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, tipoMunicipio.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El tipo de municipio con código " + tipoMunicipio.getCodigo() + " ha sido eliminado.");
                tiposMunicipios.remove(tipoMunicipio);
            } else {
                System.out.println("No se pudo eliminar el tipo de municipio con código " + tipoMunicipio.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarTipoMunicipioDataBase(TipoMunicipio tipoMunicipio) {
        String sql = "UPDATE TTipoMunicipio SET TMNombre = ? WHERE TMCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, tipoMunicipio.getNombre());
            declaracion.setString(2, tipoMunicipio.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El tipo de municipio con código " + tipoMunicipio.getCodigo() + " ha sido actualizado.");
            } else {
                System.out.println("No se pudo actualizar el tipo de municipio con código " + tipoMunicipio.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarTipoMunicipio(TipoMunicipio tipoMunicipio) {
        agregarTipoMunicipioDataBase(tipoMunicipio);
    }

    public void eliminarTipoMunicipio(TipoMunicipio tipoMunicipio) {
        eliminarTipoMunicipioDataBase(tipoMunicipio);
    }

    public void actualizarTipoMunicipio(TipoMunicipio tipoMunicipio) {
        actualizarTipoMunicipioDataBase(tipoMunicipio);
    }

    public TipoMunicipio buscarTipoMunicipio(String codigo) {
        for (TipoMunicipio tipoMunicipio : tiposMunicipios) {
            if (tipoMunicipio.getCodigo().equals(codigo)) {
                return tipoMunicipio;
            }
        }
        return null;
    }

    public void eliminarTipoMunicipioConCodigo(String codigo) {
        TipoMunicipio tipoMunicipio = buscarTipoMunicipio(codigo);
        if (tipoMunicipio != null) {
            eliminarTipoMunicipio(tipoMunicipio);
        } else {
            System.out.println("No se encontró un tipo de municipio con el código " + codigo + ".");
        }
    }

    // Métodos CRUD para Usuario
    public void agregarUsuarioDataBase(Usuario usuario) {
        String sql = "INSERT INTO TUsuario (ULogin, UEmpleado, UClave, UFechaCre) VALUES (?, ?, ?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, usuario.getUsuario());
            declaracion.setString(2, usuario.getEmpleado().getCodigo());
            declaracion.setString(3, usuario.getContrasenia());
            declaracion.setDate(4, Date.valueOf(usuario.getFechaCreacion()));
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El usuario " + usuario.getUsuario() + " ha sido agregado.");

            } else {
                System.out.println("No se pudo agregar el usuario " + usuario.getUsuario() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarUsuarioDataBase(Usuario usuario) {
        String sql = "DELETE FROM TUsuario WHERE ULogin = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, usuario.getUsuario());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El usuario " + usuario.getUsuario() + " ha sido eliminado.");
                usuarios.remove(usuario);
            } else {
                System.out.println("No se pudo eliminar el usuario " + usuario.getUsuario() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarUsuarioDataBase(Usuario usuario) {
        String sql = "UPDATE TUsuario SET ULogin = ?, UClave = ? WHERE UEmpleado = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, usuario.getUsuario());
            declaracion.setString(2, usuario.getContrasenia());
            declaracion.setString(3, usuario.getEmpleado().getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("El usuario " + usuario.getUsuario() + " ha sido actualizado.");
            } else {
                System.out.println("No se pudo actualizar el usuario " + usuario.getUsuario() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarUsuario(Usuario usuario) {
        agregarUsuarioDataBase(usuario);
        usuarios.add(usuario);
    }



    public void eliminarUsuario(Usuario usuario) {
        eliminarUsuarioDataBase(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        actualizarUsuarioDataBase(usuario);
    }

    public Usuario buscarUsuario(String usuario) {
        for (Usuario nombre : usuarios) {
            if (nombre.getUsuario().equals(usuario)) {
                return nombre;
            }
        }
        return null;
    }

    public void eliminarUsuarioConCodigo(String codigo) {
        Usuario usuario = buscarUsuario(codigo);
        if (usuario != null) {
            eliminarUsuario(usuario);
        } else {
            System.out.println("No se encontró un usuario con el código " + codigo + ".");
        }
    }

    // Métodos CRUD para Profesion
    public void agregarProfesionDataBase(Profesion profesion) {
        String sql = "INSERT INTO TProfesion (PCodigo, PNombre) VALUES (?, ?)";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, profesion.getCodigo());
            declaracion.setString(2, profesion.getNombre());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La profesión con código " + profesion.getCodigo() + " ha sido agregada.");
                profesiones.add(profesion);
            } else {
                System.out.println("No se pudo agregar la profesión con código " + profesion.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarProfesionDataBase(Profesion profesion) {
        String sql = "DELETE FROM TProfesion WHERE PCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, profesion.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La profesión con código " + profesion.getCodigo() + " ha sido eliminada.");
                profesiones.remove(profesion);
            } else {
                System.out.println("No se pudo eliminar la profesión con código " + profesion.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarProfesionDataBase(Profesion profesion) {
        String sql = "UPDATE TProfesion SET PNombre = ? WHERE PCodigo = ?";
        try (Connection conexion = BaseDeDatosUtil.obtenerConexion();
             PreparedStatement declaracion = conexion.prepareStatement(sql)) {

            declaracion.setString(1, profesion.getNombre());
            declaracion.setString(2, profesion.getCodigo());
            int filasAfectadas = declaracion.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("La profesión con código " + profesion.getCodigo() + " ha sido actualizada.");
            } else {
                System.out.println("No se pudo actualizar la profesión con código " + profesion.getCodigo() + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void agregarProfesion(Profesion profesion) {
        agregarProfesionDataBase(profesion);
    }

    public void eliminarProfesion(Profesion profesion) {
        eliminarProfesionDataBase(profesion);
    }

    public void actualizarProfesion(Profesion profesion) {
        actualizarProfesionDataBase(profesion);
    }

    public Profesion buscarProfesion(String codigo) {
        for (Profesion profesion : profesiones) {
            if (profesion.getCodigo().equals(codigo)) {
                return profesion;
            }
        }
        return null;
    }

    public void eliminarProfesionConCodigo(String codigo) {
        Profesion profesion = buscarProfesion(codigo);
        if (profesion != null) {
            eliminarProfesion(profesion);
        } else {
            System.out.println("No se encontró una profesión con el código " + codigo + ".");
        }
    }

    public boolean iniciarSesion(String Nombre, String clave){


        for (Usuario usuario : usuarios) {

            if (usuario.getUsuario().equals(Nombre) && usuario.getContrasenia().equals(clave)) {

                return true;
            }
        }

        return false;
    }
}