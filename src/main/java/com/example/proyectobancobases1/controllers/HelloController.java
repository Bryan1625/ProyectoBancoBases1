package com.example.proyectobancobases1.controllers;

import com.example.proyectobancobases1.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import org.apache.poi.ss.formula.eval.NumberEval;

import java.util.ArrayList;
import java.util.Date;

public class HelloController {

    @FXML
    private void initialize() {
        TipoMuNombreMunicipio.getItems().addAll("Grande", "Mediano", "Pequeño");
        TipoMuNombreMunicipio.setValue("Pequeño");
        EmpleGeneroEmpleado.getItems().addAll("Hombre","Mujer");

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
    private ChoiceBox UtilCodigoEmpleado;
    @FXML
    private TextField UtilClave;
    @FXML
    private DatePicker UtilFechaCreacionUsuario;
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
    @FXML
    private TextField SucCodigoSucursal;
    @FXML
    private TextField SucNombreSucursal;
    @FXML
    private TextField SucDireccionSucursal;
    @FXML
    private TextField SucTelefonoSucursal;
    @FXML
    private ChoiceBox SucMunicipioSucursal;
    @FXML
    private ChoiceBox SucDepartamentoSucursal;
    @FXML
    private TextField SucPresupuestoAsignado;


    //ANCHOR CARGOS

    @FXML
    private AnchorPane AnchorCargos;
    @FXML
    private TextField CarCodigoCargo;
    @FXML
    private TextField CarNombreCargo;
    @FXML
    private TextField CarSalarioCargo;

    //ANCHOR PROFESIONES

    @FXML
    private AnchorPane AnchorProfesiones;
    @FXML
    private ChoiceBox ProfCodigoCargo;
    @FXML
    private TextField ProfNombreProfesion;

    //ANCHOR EMPLEADOS

    @FXML
    private AnchorPane AnchorEmpleados;
    @FXML
    private ChoiceBox EmpleCodigoCargo;
    @FXML
    private TextField EmpleCedulaEmpleado;
    @FXML
    private TextField EmpleNombreEmpleado;
    @FXML
    private TextField EmpleDireccionEmpleado;
    @FXML
    private TextField EmpleTelefonoEmpleado;
    @FXML
    private ChoiceBox EmpleProfesionEmpleado;
    @FXML
    private ChoiceBox EmpleGeneroEmpleado;
    @FXML
    private DatePicker EmpleFechaNacimiento;
    @FXML
    private TextField EmpleEdadEmpleado;

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //METODOS INICIO SESION
    @FXML
    private void HandleNombre() {
    }

    @FXML
    private void HandleContrasena() {
    }

    @FXML
    private void HandleIniciarSesion() {
        PanePrincipal.setVisible(true);
        PaneInicioSesion.setVisible(false);
    }

    private void MovPrincipal (Pane pane){
        PanePrincipal.setVisible(false);
        pane.setVisible(true);
    }

    //METODOS PANEL PRINCIPAL

    @FXML
    private void HandleEntidades() {

        MovPrincipal(PaneEntidades);
    }

    @FXML
    private void HandleTransacciones() {

        MovPrincipal(PaneTransacciones);
    }

    @FXML
    private void HandleReportes() {

        MovPrincipal(PaneReportes);
    }

    @FXML
    private void HandleUtilidades() {

        MovPrincipal(PaneUtilidades);
    }

    @FXML
    private void HandleAyudas() {

    }
                //METODOS DE SALIDA DE LOS PANELES
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

    private void MovEntidades(AnchorPane pane){
        PaneFormulariosEntidades.setVisible(true);
        pane.setVisible(true);
    }

    @FXML
    private void HandleDepartamentos() {

        MovEntidades(AnchorDepartamentos);

    }

    @FXML
    private void HandleTipoMunicipio() {

        MovEntidades(AnchorTipoMunicipio);

    }

    @FXML
    private void HandleMunicipio() {

        MovEntidades(AnchorMunicipio);
    }

    @FXML
    private void HandleSucursales() {

        MovEntidades(AnchorSucursales);
    }

    @FXML
    private void HandleCargos() {

        MovEntidades(AnchorCargos);
    }

    @FXML
    private void HandleProfesiones() {

        MovEntidades(AnchorProfesiones);
    }

    @FXML
    private void HandleEmpleados() {

        MovEntidades(AnchorEmpleados);
    }

    //METODOS FORMULARIO

    private void BackOptionFormularios(AnchorPane pane) {

        PaneFormulariosEntidades.setVisible(false);
        PaneEntidades.setVisible(true);
        pane.setVisible(false);
    }

           //METODOS SALIDAS DE FORMULARIOS
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
        SucDepartamentoSucursal.getItems().clear();

        for (int i = 0; i < Departamentos.size();i++){

            MunDepartamentoUbicacion.getItems().add(Departamentos.get(i).getNombre());
            MunDepartamentoUbicacion.setValue(Departamentos.get(i).getNombre());
            SucDepartamentoSucursal.getItems().add(Departamentos.get(i).getNombre());
            SucDepartamentoSucursal.setValue(Departamentos.get(i).getNombre());

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

        RecorrerMunicipios();

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

    private void RecorrerMunicipios (){//RECORRRE LOS TIPOS EXISTENTES PARA PONERLO EN LAS CHOICE BOX

        ArrayList<Municipio> Municipios = BancoABC.getMunicipiosConSede();
        SucMunicipioSucursal.getItems().clear();

        for (int i = 0; i < Municipios.size();i++){

            SucMunicipioSucursal.getItems().add(Municipios.get(i).getNombre());
            SucMunicipioSucursal.setValue(Municipios.get(i).getNombre());

        }
    }

    //METODOS FORMULARIOS SUCURSAL

    private String codigoSucursal;
    private String nombreSucursal;
    private String direccionSucursal;
    private String telefonoSucursal;
    private String municipioSucursal;
    private String departamentoSucursal;
    private int presupuestoAsignado;

    private void GetDataSuc (){

        codigoSucursal = SucCodigoSucursal.getText();
        nombreSucursal = SucNombreSucursal.getText();
        direccionSucursal = SucDireccionSucursal.getText();
        telefonoSucursal = SucTelefonoSucursal.getText();
        municipioSucursal = SucMunicipioSucursal.getValue().toString();
        departamentoSucursal = SucDepartamentoSucursal.getValue().toString();
        presupuestoAsignado = Integer.parseInt(SucPresupuestoAsignado.getText());
    }

    @FXML
    private void SucBtnGuardar(){

        GetDataSuc();

        Sucursal NuevaSucursal = new Sucursal(codigoSucursal,nombreSucursal,municipioSucursal,departamentoSucursal,presupuestoAsignado);

        BancoABC.agregarSucursal(NuevaSucursal);

        RecorrerSucursales();

        for (int i =0; i< BancoABC.getSucursales().size();i++){
            System.out.println("Sucursales: "+BancoABC.getSucursales().get(i));

            System.out.println("Sucursales: "+BancoABC.getSucursales().get(i).getCodigo());
            System.out.println("Nombre: "+BancoABC.getSucursales().get(i).getNombre());
        }
    }
    @FXML
    private void SucBtnEliminar(){

    }
    @FXML
    private void SucBtnEditar(){

    }
    @FXML
    private void SucBtnBuscar(){

    }

    private void RecorrerSucursales(){ //RECORRE LAS SUCURSALES PARA LAS CHOICEBOX

        ArrayList<Sucursal> Sucursales = BancoABC.getSucursales();

        TransSucursalContrato.getItems().clear();

        for (int i = 0; i < Sucursales.size();i++){

            TransSucursalContrato.getItems().add(Sucursales.get(i).getNombre());
            TransSucursalContrato.setValue(Sucursales.get(i).getNombre());

        }


    }

    //METODO FORMULARIOS CARGO

    private String codigoCargo;
    private String nombreCargo;
    private double salarioCargo;


    private void GetDataCargo(){

        codigoCargo = CarCodigoCargo.getText();
        nombreCargo = CarNombreCargo.getText();
        salarioCargo = Integer.parseInt(CarSalarioCargo.getText());

    }

    @FXML
    private void CarBtnGuardar(){


        GetDataCargo();

        Cargo NuevoCargo = new Cargo(codigoCargo, nombreCargo,salarioCargo,"01");

        BancoABC.agregarCargo(NuevoCargo);

        RecorrerCargos();

        for (int i =0; i< BancoABC.getCargos().size();i++){
            System.out.println("Cargo: "+BancoABC.getCargos().get(i));

            System.out.println("Cargo: "+BancoABC.getCargos().get(i).getCodigo());
            System.out.println("Nombre: "+BancoABC.getCargos().get(i).getNombre());
        }

    }
    @FXML
    private void CarBtnEliminar(){

    }
    @FXML
    private void CarBtnEditar(){

    }
    @FXML
    private void CarBtnBuscar(){

    }

    private void RecorrerCargos(){

        ArrayList<Cargo> Cargos = BancoABC.getCargos();

        ProfCodigoCargo.getItems().clear();
        TransCargoContrato.getItems().clear();

        for (int i = 0; i < Cargos.size();i++){

            ProfCodigoCargo.getItems().add(Cargos.get(i).getCodigo());
            ProfCodigoCargo.setValue(Cargos.get(i).getCodigo());
            TransCargoContrato.getItems().add(Cargos.get(i).getCodigo());
            TransCargoContrato.setValue(Cargos.get(i).getCodigo());

        }
    }

    //METODOS FORMULARIO PROFESIONES

    private String codigoProfesionCargo;
    private String nombreProfesion;

    private void GetDataProfesion(){
        codigoProfesionCargo = ProfCodigoCargo.getValue().toString();
        nombreProfesion = ProfNombreProfesion.getText();
    }

    @FXML
    private void ProfBtnGuardar(){

        GetDataProfesion();

        Profesion NuevoProfesion = new Profesion(codigoProfesionCargo,nombreProfesion);

        BancoABC.agregarProfesion(NuevoProfesion);

        RecorrerProfesiones();

    }
    @FXML
    private void ProfBtnEliminar(){

    }
    @FXML
    private void ProfBtnEditar(){

    }
    @FXML
    private void ProfBtnBuscar(){

    }

    private void RecorrerProfesiones(){

        ArrayList<Profesion> Profesiones = BancoABC.getProfesiones();

        EmpleProfesionEmpleado.getItems().clear();

        for (int i = 0; i < Profesiones.size();i++){

            EmpleProfesionEmpleado.getItems().add(Profesiones.get(i).getNombre());
            EmpleProfesionEmpleado.setValue(Profesiones.get(i).getNombre());

        }
    }

    //METODO FORMULARIO EMPLEADOS
    private String cedulaEmpleado;
    private String nombreEmpleado;
    private String telefonoEmpleado;
    private String direccionEmpleado;
    private String profesionEmpleado;
    private String generoEmpleado;
    private String fechaNacimiento;
    private String edadEmpleado;

    private void GetDataEmpleado(){
        cedulaEmpleado = EmpleCedulaEmpleado.getText();
        nombreEmpleado = EmpleNombreEmpleado.getText();
        telefonoEmpleado = EmpleTelefonoEmpleado.getText();
        direccionEmpleado = EmpleDireccionEmpleado.getText();
        profesionEmpleado = EmpleProfesionEmpleado.getValue().toString();
        generoEmpleado = EmpleGeneroEmpleado.getValue().toString();
        fechaNacimiento = EmpleFechaNacimiento.getValue().toString();
        edadEmpleado = EmpleEdadEmpleado.getText();

    }

    @FXML
    private void EmpleBtnGuardar(){

        GetDataEmpleado();

        Empleado NuevoEmpleado = new Empleado(cedulaEmpleado,nombreEmpleado,direccionEmpleado,telefonoEmpleado,profesionEmpleado);

        BancoABC.agregarEmpleado(NuevoEmpleado);

        RecorrerEmpleados();

        for (int i =0; i< BancoABC.getEmpleados().size();i++){
            System.out.println("Empleado: "+BancoABC.getEmpleados().get(i));

            System.out.println("Empleado: "+BancoABC.getEmpleados().get(i).getCedula());
            System.out.println("Nombre: "+BancoABC.getEmpleados().get(i).getNombre());
        }

    }
    @FXML
    private void EmpleBtnEliminar(){

    }
    @FXML
    private void EmpleBtnEditar(){

    }
    @FXML
    private void EmpleBtnBuscar(){

    }

    private void RecorrerEmpleados(){

        ArrayList<Empleado> Empleados = BancoABC.getEmpleados();

        UtilCodigoEmpleado.getItems().clear();
        TransEmpleado.getItems().clear();

        for (int i = 0; i < Empleados.size();i++){

            UtilCodigoEmpleado.getItems().add(Empleados.get(i).getCedula());
            UtilCodigoEmpleado.setValue(Empleados.get(i).getCedula());
            TransEmpleado.getItems().add(Empleados.get(i).getCedula());
            TransEmpleado.setValue(Empleados.get(i).getCedula());

        }
    }


    //METODO FORMULARIOS TRANSACCIONES

    private String numeroContrato;
    private String fechaContrato;
    private String fechaInicio;
    private String fechaTerminacion;
    private String cargoContrato;
    private String sucursalContrato;
    private String empleado;

    private void GetDataTransaccion(){

        numeroContrato = TransNumeroContrato.getText();
        fechaContrato = TransFechaContrato.getValue().toString();
        fechaInicio = TransFechaInicio.getValue().toString();
        fechaTerminacion = TransFechaTerminacion.getValue().toString();
        cargoContrato = TransCargoContrato.getValue().toString();
        sucursalContrato = TransSucursalContrato.getValue().toString();
        empleado = TransEmpleado.getValue().toString();
    }

    @FXML
    private void TransBtnGuardar(){

        GetDataTransaccion();

        Contrato NuevoContrato = new Contrato(numeroContrato,fechaInicio,fechaTerminacion,sucursalContrato,cargoContrato);

        BancoABC.agregarContrato(NuevoContrato);

        for (int i =0; i< BancoABC.getContratos().size();i++){
            System.out.println("Contratos: "+BancoABC.getContratos().get(i));

            System.out.println("Contratos: "+BancoABC.getContratos().get(i).getCodigo());
        }


    }
    @FXML
    private void TransBtnEliminar(){

    }
    @FXML
    private void TransBtnEditar(){

    }
    @FXML
    private void TransBtnBuscar(){

    }

    //METODOS FORMULARIOS USUARIOS

    private String loginUsuario;
    private String codigoEmpleado;
    private String claveUsuario;
    private String fechaCreacion;

    private void GetDataUsuarios(){
        loginUsuario = UtilLogin.getText();
        codigoEmpleado = UtilCodigoEmpleado.getValue().toString();
        claveUsuario = UtilClave.getText();
        fechaCreacion = UtilFechaCreacionUsuario.getValue().toString();
    }

    @FXML
    private void UtilBtnGuardar(){

        GetDataUsuarios();

        Usuario NuevoUsuario = new Usuario(loginUsuario,claveUsuario,codigoEmpleado);

        BancoABC.agregarUsuario(NuevoUsuario);

    }
    @FXML
    private void UtilBtnEliminar(){

    }
    @FXML
    private void UtilBtnEditar(){

    }
    @FXML
    private void UtilBtnBuscar(){

    }

}