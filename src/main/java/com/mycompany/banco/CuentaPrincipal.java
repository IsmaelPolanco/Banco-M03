package com.mycompany.banco;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CuentaPrincipal {

    @FXML
    private Button volver;

    @FXML
    private Button cerrarsesion;

    @FXML
    private TextField saldo;

    @FXML
    private TextField operacionrealizada;

    @FXML
    private RadioButton ingresar;

    @FXML
    private RadioButton retirar;

    @FXML
    private RadioButton transferir;

    @FXML
    private ToggleGroup operaciones;

    @FXML
    private Button textoOperacion;

    private Login currentUser;

    private Billetes billetes; // Objeto de la clase Billetes

    User usuario;

    private double ingreso = 0;

    private List<User> users = App.login.users;

    public CuentaPrincipal(int saldoPrincipal) {
    }

    public void setLogin(Login login) {
        // this.login = login;
    }

    @FXML
    public void handleVolverButton() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void cerrarsesion(ActionEvent event) throws IOException {
        // vuelve a  la vista a la página de inicio 
        App.setRoot("primary");
    }

    public void initialize() {
        usuario = App.login.currentUser;
        int saldoActual = usuario.getSaldo();
        saldo.setText(String.valueOf(saldoActual));
        billetes = new Billetes(500, 200, 100, 50, 20, 10, 5);
    }

    @FXML
    private void saldo(ActionEvent event) {
        int saldoActual = usuario.getSaldo();
        saldo.setText(String.valueOf(saldoActual));
    }

    public void actualizarSaldo() {
        double actualSaldo = App.login.currentUser.getSaldo();
        double newSaldo = actualSaldo + ingreso;
        saldo.setText("Saldo: " + newSaldo);
        for (User user : users) {
            if (user.getUsername().equals(usuario.getUsername())) {
                user.setSaldo((int) newSaldo);
                break;
            }
        }
    }

    @FXML
    void b500() {
        ingreso += 500;
        operacionrealizada.setText(Double.toString(ingreso));
    }

    @FXML
    void b200() {
        ingreso += 200;
        operacionrealizada.setText(Double.toString(ingreso));
    }

    @FXML
    void b100() {
        ingreso += 100;
        operacionrealizada.setText(Double.toString(ingreso));
    }

    @FXML
    void b50() {
        ingreso += 50;
        operacionrealizada.setText(Double.toString(ingreso));
    }

    @FXML
    void b20() {
        ingreso += 20;
        operacionrealizada.setText(Double.toString(ingreso));
    }

    @FXML
    void b10() {
        ingreso += 10;
        operacionrealizada.setText(Double.toString(ingreso));
    }

    @FXML
    void b5() {
        ingreso += 5;
        operacionrealizada.setText(Double.toString(ingreso));
    }

    //  textoOperacion.setDisable(true);
    @FXML
    private void handletextoOperacionextoOperacion(ActionEvent event) {
        // Verifica que el usuario haya ingresado un monto
       if (ingreso > 0) {
            // Actualiza el saldo del usuario
            usuario.setSaldo((int) (usuario.getSaldo() + ingreso));
            // Actualiza el saldo mostrado en la interfaz
            saldo.setText(String.valueOf(usuario.getSaldo()));
            // Reinicia la variable "ingreso" a cero
            ingreso = 0;
            // Limpia el campo "operacionrealizada"
            operacionrealizada.setText("");
        } else {
            // Muestra una alerta si el usuario no ha ingresado un monto
            Alert alert = new Alert(Alert.AlertType.ERROR, "Debe ingresar un monto");
            alert.showAndWait();
        } 
    }

	public void setSaldo(double saldoPrincipal) {
	}

    public double getSaldo() {
        return 0;
    }
}