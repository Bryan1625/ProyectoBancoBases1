package com.example.proyectobancobases1.util;

import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDatosUtil {
    private static final String RUTA_BASE_DATOS = "/DataBase.accdb";

    public static Connection obtenerConexion() throws SQLException {
        try {
            URL resource = BaseDeDatosUtil.class.getResource(RUTA_BASE_DATOS);
            if (resource == null) {
                throw new IllegalArgumentException("Archivo de base de datos no encontrado");
            }
            String rutaBaseDatos = new java.io.File(resource.toURI()).getAbsolutePath();
            String urlConexion = "jdbc:ucanaccess://" + rutaBaseDatos;
            Connection conexion = DriverManager.getConnection(urlConexion);

            // Asegurarse de que la conexión no esté en modo autocommit
            conexion.setAutoCommit(false);

            return conexion;
        } catch (URISyntaxException e) {
            throw new SQLException("Error al convertir la ruta de la base de datos", e);
        }
    }
}

