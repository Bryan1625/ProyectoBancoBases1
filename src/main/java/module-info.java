module com.example.proyectobancobases1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectobancobases1 to javafx.fxml;
    exports com.example.proyectobancobases1;
}