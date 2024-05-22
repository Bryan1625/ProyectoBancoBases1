package com.example.proyectobancobases1.controllers;

import com.example.proyectobancobases1.model.Banco;
import com.example.proyectobancobases1.model.Departamento;
import com.example.proyectobancobases1.model.Municipio;
import com.example.proyectobancobases1.model.TipoMunicipio;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class HelloController {

    @FXML
    private void initialize(){
        TipoMuNombreMunicipio.getItems().addAll("Grande","Mediano","Pequeño");
        TipoMuNombreMunicipio.setValue("Pequeño");

    }

    //BANCO

    Banco BancoABC = new Banco();

    // PANEL INICIO SESION

    @FXML
    private Pane PaneInicioSesion;
    @FXML
    private TextField NombreSesion;
    @FXML
    private TextField ContrasenaSesion;
    @FXML
    private Button BtnIniciarSesion;

    //PANEL PRINCIPAL

    @FXML
    private Pane PanePrincipal;
    @FXML
    private Button BtnEntidades;
    @FXML
    private Button BtnTransacciones;
    @FXML
    private Button BtnReportes;
    @FXML
    private Button BtnUtilidades;
    @FXML
    private Button BtnAyudas;

    //PANEL ENTIDADES

    @FXML
    private Pane PaneEntidades;
    @FXML
    private Button BtnDepartamentos;
    @FXML
    private Button BtnTipoMunicipio;
    @FXML
    private Button BtnMunicipio;
    @FXML
    private Button BtnSucursales;
    @FXML
    private Button BtnCargos;
    @FXML
    private Button BtnProfesiones;
    @FXML
    private Button BtnEmpleados;

    //PANEL TRANSACCIONES

    @FXML
    private Pane PaneTransacciones;
    @FXML
    private TextField TransNumeroContrato;
    @FXML
    private DatePicker TransFechaContrato;
    @FXML
    private DatePicker TransFechaInicio;
    @FXML
    private DatePicker TransFechaTerminacion;
    @FXML
    private ChoiceBox TransCargoContrato;
    @FXML
    private ChoiceBox TransSucursalContrato;
    @FXML
    private ChoiceBox TransEmpleado;
    @FXML
    private TextArea TransDescripcionContrato;
    @FXML
    private Button TransBtnGuardar;
    @FXML
    private Button TransBtnEliminar;
    @FXML
    private Button TransBtnEditar;
    @FXML
    private Button TransBtnBuscar;

    //PANEL REPORTES

    @FXML
    private Pane PaneReportes;
    @FXML
    private Button BtnListarSucursales;
    @FXML
    private Button BtnInformeEmpleados;

    //PANEL UTILIDADES

    @FXML
    private Pane PaneUtilidades;
    @FXML
    private TextField UtilLogin;
    @FXML
    private TextField UtilCodigoEmpleado;
    @FXML
    private TextField UtilClave;
    @FXML
    private TextField UtilFechaCreacionUsuario;
    @FXML
    private Button UtilBtnGuardar;
    @FXML
    private Button UtilBtnEliminar;
    @FXML
    private Button UtilBtnEditar;
    @FXML
    private Button UtilBtnBuscar;
    @FXML
    private Button UtilBtnBitacoraUsuarios;

    // FORMULARIOS ENTIDADES

    @FXML
    private Pane PaneFormulariosEntidades;

    //ANCHOR DEPARTAMENTOS

    @FXML
    private AnchorPane AnchorDepartamentos;
    @FXML
    private TextField DepCodigoDepartamento;
    @FXML
    private TextField DepNombreDepartamento;
    @FXML
    private TextField DepPoblacionDepartamento;
    @FXML
    private Button DepBtnGuardar;
    @FXML
    private Button DepBtnEliminar;
    @FXML
    private Button DepBtnEditar;
    @FXML
    private Button DepBtnBuscar;

    //ANCHOR TIPO MUNICIPIOS

    @FXML
    private AnchorPane AnchorTipoMunicipio;
    @FXML
    private TextField TipoMuCodigoMunicipio;
    @FXML
    private ChoiceBox TipoMuNombreMunicipio;


    //ANCHOR MUNICIPIOS

    @FXML
    private AnchorPane AnchorMunicipio;
    @FXML
    private TextField MunCodigoMunicipio;
    @FXML
    private TextField MunNombreMunicipio;
    @FXML
    private TextField MunPoblacionEstimada;
    @FXML
    private ChoiceBox MunDepartamentoUbicacion;
    @FXML
    private ChoiceBox MunTipoMunicipio;


    //ANCHOR SUCURSALES

    @FXML
    private AnchorPane AnchorSucursales;

    //ANCHOR CARGOS

    @FXML
    private AnchorPane AnchorCargos;

    //ANCHOR PROFESIONES

    @FXML
    private AnchorPane AnchorProfesiones;

    //ANCHOR EMPLEADOS

    @FXML
    private AnchorPane AnchorEmpleados;


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //METODOS INICIO SESION
    @FXML
    private void HandleNombre() {
        System.out.println("Inicio Sesion");
    }

    @FXML
    private void HandleContrasena() {
    }

    @FXML
    private void HandleIniciarSesion() {
        PanePrincipal.setVisible(true);
        PaneInicioSesion.setVisible(false);
    }

    //METODOS PANEL PRINCIPAL

    @FXML
    private void HandleEntidades() {

        PaneEntidades.setVisible(true);
        PanePrincipal.setVisible(false);
    }

    @FXML
    private void HandleTransacciones() {

        PaneTransacciones.setVisible(true);
        PanePrincipal.setVisible(false);
    }

    @FXML
    private void HandleReportes() {

        PaneReportes.setVisible(true);
        PanePrincipal.setVisible(false);
    }

    @FXML
    private void HandleUtilidades() {

        PaneUtilidades.setVisible(true);
        PanePrincipal.setVisible(false);
    }

    @FXML
    private void HandleAyudas() {

    }

    @FXML
    private void BackEntPrincipal(){

        BackOptionPanelPrincipal(PaneEntidades);
    }

    @FXML
    private void BackTransPrincipal(){

        BackOptionPanelPrincipal(PaneTransacciones);
    }

    @FXML
    private void BackRepPrincipal(){

        BackOptionPanelPrincipal(PaneReportes);
    }

    @FXML
    private void BackUtilPrincipal(){

        BackOptionPanelPrincipal(PaneUtilidades);
    }

    private void BackOptionPanelPrincipal(Pane pane){

        pane.setVisible(false);
        PanePrincipal.setVisible(true);

    }

    //METODOS PANEL ENTIDADES

    @FXML
    private void HandleDepartamentos() {

        PaneFormulariosEntidades.setVisible(true);
        AnchorDepartamentos.setVisible(true);

    }

    @FXML
    private void HandleTipoMunicipio() {

        PaneFormulariosEntidades.setVisible(true);
        AnchorTipoMunicipio.setVisible(true);

    }

    @FXML
    private void HandleMunicipio() {

        PaneFormulariosEntidades.setVisible(true);
        AnchorMunicipio.setVisible(true);
    }

    @FXML
    private void HandleSucursales() {

        PaneFormulariosEntidades.setVisible(true);
        AnchorSucursales.setVisible(true);
    }

    @FXML
    private void HandleCargos() {

        PaneFormulariosEntidades.setVisible(true);
        AnchorCargos.setVisible(true);
    }

    @FXML
    private void HandleProfesiones() {

        PaneFormulariosEntidades.setVisible(true);
        AnchorProfesiones.setVisible(true);
    }

    @FXML
    private void HandleEmpleados() {

        PaneFormulariosEntidades.setVisible(true);
        AnchorEmpleados.setVisible(true);
    }

    //METODOS FORMULARIO

    private void BackOptionFormularios(AnchorPane pane) {

        PaneFormulariosEntidades.setVisible(false);
        PaneEntidades.setVisible(true);
        pane.setVisible(false);
    }

    @FXML
    private void BackDepartamentos(){
        BackOptionFormularios(AnchorDepartamentos);
    }

    @FXML
    private void BackTipoMunicipio(){
        BackOptionFormularios(AnchorTipoMunicipio);
    }

    @FXML
    private void BackMunicipios(){
        BackOptionFormularios(AnchorMunicipio);
    }

    @FXML
    private void BackSucursales(){
        BackOptionFormularios(AnchorSucursales);
    }

    @FXML
    private void BackCargos(){
        BackOptionFormularios(AnchorCargos);
    }

    @FXML
    private void BackProfesiones(){
        BackOptionFormularios(AnchorProfesiones);
    }

    @FXML
    private void BackEmpleados(){
        BackOptionFormularios(AnchorProfesiones);
    }


    //METODO FORMULARIO DEPARTAMENTOS

    private String codigoDepartamento;
    private String nombreDepartamento;
    private int poblacionDepartamento;

    private void GetDataDep (){
        codigoDepartamento = DepCodigoDepartamento.getText();
        nombreDepartamento = DepNombreDepartamento.getText();
        poblacionDepartamento = Integer.parseInt(DepPoblacionDepartamento.getText());
    }

    @FXML //CREA UN DEPARTAMENTO NUEVO
    private void DepBtnGuardar() {

        GetDataDep();

        Departamento NuevoDepartamento = new Departamento(codigoDepartamento, nombreDepartamento, poblacionDepartamento);

        BancoABC.agregarDepartamentoConSede(NuevoDepartamento);

        RecorrerDepartamentos();

        for (int i =0; i< BancoABC.getDepartamentosConSede().size();i++){
            System.out.println("Departamento: "+BancoABC.getDepartamentosConSede().get(i));

            System.out.println("Departamento: "+BancoABC.getDepartamentosConSede().get(i).getCodigo());
            System.out.println("Nombre: "+BancoABC.getDepartamentosConSede().get(i).getNombre());
            System.out.println("Poblacion: "+BancoABC.getDepartamentosConSede().get(i).getPoblacion());
        }

    }

    @FXML //EDITA DEPARTAMENTO NUEVO
    private void DepBtnEditar(){

    }

    @FXML //ELIMINA UN DEPARTAMENTO
    private void DepBtnEliminar(){

    }

    @FXML //BUSCA UN DEPARTAMENTO
    private void DepBtnBuscar(){

    }

    private void RecorrerDepartamentos(){

        ArrayList<Departamento> Departamentos = BancoABC.getDepartamentosConSede();

        MunDepartamentoUbicacion.getItems().clear();

        for (int i = 0; i < Departamentos.size();i++){

            MunDepartamentoUbicacion.getItems().add(Departamentos.get(i).getNombre());
            MunDepartamentoUbicacion.setValue(Departamentos.get(i).getNombre());

        }

    }

    //METODO FORMULARIOS TIPO MUNICIPIO

    private String codigoTipoMunicipio;
    private String nombreTipoMunicipio;

    private void GetDataTipoMu(){

        codigoTipoMunicipio = TipoMuCodigoMunicipio.getText();
        nombreTipoMunicipio = TipoMuNombreMunicipio.getValue().toString();
    }

    @FXML //AGREGA UN TIPO MUNICIPIO
    private void TipoMuBtnGuardar(){

        System.out.println("HolaMundo");

        GetDataTipoMu();

        TipoMunicipio NuevoTipoMunicipio = new TipoMunicipio(nombreTipoMunicipio,codigoTipoMunicipio);

        BancoABC.agregarTipoMunicipio(NuevoTipoMunicipio);

        RecorrerTipos();

        for (int i =0; i< BancoABC.getTiposMunicipios().size();i++){
            System.out.println("TipoMunicipio: "+BancoABC.getTiposMunicipios().get(i));

            System.out.println("Tipo Municipio: "+BancoABC.getTiposMunicipios().get(i).getCodigo());
            System.out.println("Nombre: "+BancoABC.getTiposMunicipios().get(i).getNombre());
        }

    }
    @FXML //ELIMINA UN TIPO MUNICIPIO
    private void TipoMuBtnEliminar(){

    }
    @FXML //EDITAR UN TIPO MUNICIPIO
    private void TipoMuBtnEditar(){

    }
    @FXML //BUSCAR UN TIPO MUNICIPIO
    private void TipoMuBtnBuscar(){

    }


    private void RecorrerTipos (){//RECORRRE LOS TIPOS EXISTENTES PARA PONERLO EN LAS CHOICE BOX

        ArrayList<TipoMunicipio> Tipos = BancoABC.getTiposMunicipios();
        MunTipoMunicipio.getItems().clear();

        for (int i = 0; i < Tipos.size();i++){

            MunTipoMunicipio.getItems().add(Tipos.get(i).getNombre());
            MunTipoMunicipio.setValue(Tipos.get(i).getNombre());

        }
    }

    //METODOS FORMULARIOS MUNICIPIOS

    private String codigoMunicipio;
    private String nombreMunicipio;
    private int poblacionMunicipio;
    private String departamentoUbica;
    private String tipoMunicipio;

    private void GetDataMun(){

        codigoMunicipio = MunCodigoMunicipio.getText();
        nombreMunicipio = MunNombreMunicipio.getText();
        poblacionMunicipio = Integer.parseInt(MunPoblacionEstimada.getText());
        departamentoUbica = MunDepartamentoUbicacion.getValue().toString();
        tipoMunicipio = MunTipoMunicipio.getValue().toString();
    }

    @FXML
    private void MunBtnGuardar(){

        GetDataMun();

        Municipio NuevoMunicipio = new Municipio(codigoMunicipio,nombreMunicipio,poblacionMunicipio,tipoMunicipio,departamentoUbica);

        BancoABC.agregarMunicipioConSede(NuevoMunicipio);

        for (int i =0; i< BancoABC.getMunicipiosConSede().size();i++){
            System.out.println("Municipio: "+BancoABC.getMunicipiosConSede().get(i));

            System.out.println("Municipio: "+BancoABC.getMunicipiosConSede().get(i).getCodigo());
            System.out.println("Nombre: "+BancoABC.getMunicipiosConSede().get(i).getNombre());
        }



    }
    @FXML
    private void MunBtnEditar(){

    }
    @FXML
    private void MunBtnEliminar(){

    }
    @FXML
    private void MunBtnBuscar(){

    }

}