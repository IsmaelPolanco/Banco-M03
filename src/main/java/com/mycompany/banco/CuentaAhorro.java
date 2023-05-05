package com.mycompany.banco;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CuentaAhorro {

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

    private Billetes billetes;

    private double saldoActual;

    private List<User> users;

    private double ingreso = 0;

    User usuario;
    
    public CuentaAhorro(){}

    public CuentaAhorro(double saldoAhorro) {
        this.saldoActual = saldoAhorro;
        this.billetes = new Billetes(500, 200, 100, 50, 20, 10, 5);
    }

    public double getSaldo() {
        return saldoActual;
    }

    public void setSaldo(double saldo) {
        this.saldoActual = saldo;
    }

    public double getSaldoAhorro() {
        return 0;
    }

    public void setSaldoAhorro(double saldoCuentaAhorro) {
    }

    @FXML
    public void handleVolverButton() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void cerrarsesion(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    public void initialize() {
        usuario = App.login.currentUser;
        saldoActual = usuario.getSaldoTotal();
        saldo.setText(String.valueOf(saldoActual));
        billetes = new Billetes(500, 200, 100, 50, 20, 10, 5);
    }

    @FXML
    private void handleSaldo(ActionEvent event) {
        saldoActual = usuario.getSaldoTotal();
        saldo.setText(String.valueOf(saldoActual));
    }

    public void actualizarSaldo() {
        double newSaldo = saldoActual + ingreso;
        saldoActual = newSaldo;
        usuario.setSaldoTotal(newSaldo);

    }

    public void ingresar(double monto) {
        if (monto > 0) {
            ingreso = monto;
            actualizarSaldo();
            System.out.println("Ingreso exitoso");
        }
    }

    public void retirar(double monto) {
        if (monto > 0 && saldoActual >= monto) {
            saldoActual = monto;
            actualizarUsuarioSaldo();
            System.out.println("Retiro exitoso");
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    public void transferir(double monto, CuentaAhorro cuentaDestino) {
        if (monto > 0 && saldoActual >= monto) {
            saldoActual = -monto;
            cuentaDestino.ingresar(monto);
            actualizarUsuarioSaldo();
            System.out.println("Transferencia exitosa");
        } else {
            System.out.println("Saldo insuficiente para realizar una transferencia");
        }
    }

    private void actualizarUsuarioSaldo() {
        User currentUser = App.login.currentUser;
        for (User user : users) {
            if (user.getUsername().equals(currentUser.getUsername())) {
                user.setSaldoCuentaAhorro((int) saldoActual);
                break;
            }
        }
    }

    public Billetes getBilletes() {
        return billetes;
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
}