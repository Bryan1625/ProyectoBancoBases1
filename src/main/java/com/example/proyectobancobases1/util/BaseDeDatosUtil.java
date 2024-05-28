package com.example.proyectobancobases1.util;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.proyectobancobases1.model.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class BaseDeDatosUtil {
    private static final String RUTA_BASE_DATOS = "/DataBase.accdb";

    public static void asignarPropiedad(){
        System.setProperty("hsqldb.method_class_names", "net.ucanaccess.converters.*"); // see http://hsqldb.org/doc/2.0/guide/sqlroutines-chapt.html#src_jrt_access_control
    }

    public static Connection obtenerConexion() throws SQLException {
        asignarPropiedad();
        try {
            URL resource = BaseDeDatosUtil.class.getResource(RUTA_BASE_DATOS);
            if (resource == null) {
                throw new IllegalArgumentException("Archivo de base de datos no encontrado");
            }
            String rutaBaseDatos = new java.io.File(resource.toURI()).getAbsolutePath();
            String urlConexion = "jdbc:ucanaccess://" + rutaBaseDatos;
            return DriverManager.getConnection(urlConexion);
        } catch (URISyntaxException e) {
            throw new SQLException("Error al convertir la ruta de la base de datos", e);
        }
    }

    public static void generarReporteEmpleadosPorSucursal(Banco banco, String nombreSucursal) {
        asignarPropiedad();
        try (Connection conexion = obtenerConexion()) {
            String query = "SELECT E.ECodigo, E.ENombre, E.EGenero, C.CNombre AS Cargo, C.CSalario " +
                    "FROM TEmpleado AS E " +
                    "INNER JOIN TContrato AS Con ON E.ECodigo = Con.CEmpleado " +
                    "INNER JOIN TCargo AS C ON Con.CCargo = C.CCodigo " +
                    "INNER JOIN TSucursal AS S ON Con.CSucursal = S.SCodigo " +
                    "WHERE S.SNombre = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombreSucursal);
            ResultSet resultSet = statement.executeQuery();

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(crearListaEmpleados(resultSet, banco));
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("DataSource", dataSource);

            JasperPrint print = JasperFillManager.fillReport("reporte_empleados.jrxml", parametros, new JREmptyDataSource());
            File pdfFile = new File("reporte_empleados_por_sucursal.pdf");
            exportarAPdf(print, pdfFile);
            abrirArchivo(pdfFile);
        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }
    }


    public static void generarReporteSucursalesPorDepartamento(Banco banco, String nombreDepartamento) {
        asignarPropiedad();
        try (Connection conexion = obtenerConexion()) {
            String query = "SELECT S.* " +
                    "FROM TSucursal AS S " +
                    "INNER JOIN TDepartamento AS D ON S.SDepartamento = D.DCodigo " +
                    "WHERE D.DNombre = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, nombreDepartamento);
            ResultSet resultSet = statement.executeQuery();

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(crearListaSucursales(resultSet, banco));
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("DataSource", dataSource);

            JasperPrint print = JasperFillManager.fillReport("reporte_sucursales.jasper", parametros, new JREmptyDataSource());
            File pdfFile = new File("reporte_sucursales_por_departamento.pdf");
            exportarAPdf(print, pdfFile);
            abrirArchivo(pdfFile);
        } catch (SQLException | JRException e) {
            e.printStackTrace();
        }
    }

    private static List<Empleado> crearListaEmpleados(ResultSet resultSet, Banco banco) throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        while (resultSet.next()) {
            Empleado empleado = new Empleado(
                    resultSet.getString("ECodigo"),
                    resultSet.getString("ENombre"),
                    resultSet.getString("EGenero")
            );
            empleados.add(empleado);
        }
        return empleados;
    }

    private static List<Sucursal> crearListaSucursales(ResultSet resultSet, Banco banco) throws SQLException {
        List<Sucursal> sucursales = new ArrayList<>();
        while (resultSet.next()) {
            Sucursal sucursal = new Sucursal(
                    resultSet.getString("SCodigo"),
                    resultSet.getString("SNombre"),
                    banco.buscarMunicipioConSede(resultSet.getString("SMunicipio")),
                    banco.buscarDepartamentoConSede(resultSet.getString("SDepartamento")),
                    resultSet.getDouble("SPresupuesto")
            );
            sucursales.add(sucursal);
        }
        return sucursales;
    }

    public static void exportarAPdf(JasperPrint print, File pdfFile) {
        try {
            JasperExportManager.exportReportToPdfFile(print, pdfFile.getAbsolutePath());
        } catch (JRException e) {
            e.printStackTrace();
        }
    }

    public static void abrirArchivo(File archivo) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivo);
            } else {
                System.out.println("El sistema no soporta la apertura automática de archivos.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


