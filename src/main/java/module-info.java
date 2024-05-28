module com.example.proyectobancobases1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires poi;
    requires poi.ooxml;
    requires java.sql;
    requires java.desktop;


    opens com.example.proyectobancobases1 to javafx.fxml;
    exports com.example.proyectobancobases1;
    exports com.example.proyectobancobases1.controllers;
    opens com.example.proyectobancobases1.controllers to javafx.fxml;
    exports com.example.proyectobancobases1.model;
}