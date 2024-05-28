package com.example.proyectobancobases1.util;

import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatosUtil {
    private static final String RUTA_BASE_DATOS = "C:\\Users\\Bryan\\Documents\\GitHub\\Bases1\\ProyectoBancoBases1\\src\\main\\resources\\DataBase.accdb";

    public static Connection obtenerConexion() throws SQLException {
        System.setProperty("hsqldb.method_class_names", "net.ucanaccess.converters.*"); // see http://hsqldb.org/doc/2.0/guide/sqlroutines-chapt.html#src_jrt_access_control
        URL resource = BaseDeDatosUtil.class.getResource("/DataBase.accdb");
        if (resource == null) {
            throw new IllegalArgumentException("Archivo de base de datos no encontrado");
        }
        String rutaBaseDatos = RUTA_BASE_DATOS;
        String urlConexion = "jdbc:ucanaccess://" + rutaBaseDatos;
        Connection conexion = DriverManager.getConnection(urlConexion);

        return conexion;
    }
}

