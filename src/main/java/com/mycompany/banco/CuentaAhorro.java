/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banco;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Ismael Polanco
 */
public class CuentaAhorro {
    
    int prova;

    @FXML
    Button volver;

    @FXML
    Button cerrarsesion;

    @FXML
    TextField saldoAhorroTexto;

    @FXML
    TextField operacionrealizada;

    @FXML
    RadioButton ingresar;

    @FXML
    RadioButton retirar;

    @FXML
    RadioButton transferir;

    @FXML
    ToggleGroup operaciones;

    @FXML
    Button realizaroperaciones;

     private Billetes billetes; // Objeto de la clase Billetes
   
     User usuario;
     
     User saldoAhorro;

    double ingreso = 0;

    public CuentaAhorro(int saldoAhorro2) {
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
        int saldoActualAhorro = usuario.getSaldoAhorro();
     //   saldoAhorro.setText(String.valueOf(saldoActualAhorro));
        billetes = new Billetes(500, 200, 100, 50, 20, 10, 5);
    }

    @FXML
    private void saldoAhorroTexto(ActionEvent event) {
        int saldoActualAhorro = usuario.getSaldoAhorro();
   //     saldoAhorro.setText(String.valueOf(saldoActualAhorro));
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
        ingreso += 510;
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
    public void handleIngresoBilletes(ActionEvent event) {
        System.out.println("==== Ingreso de Billetes ====");

        int monto = 0;
        billetes.actualizarBilletes(monto);
        operacionrealizada.setText("$" + monto);
        double actualSaldo = App.login.currentUser.getSaldo();
        double newSaldo = actualSaldo + ingreso;
      //  saldo.setText("Saldo: " + newSaldo);
    }

    @FXML
    public void handleRetiroBilletes(ActionEvent event) {
        System.out.println("==== Retiro de Billetes ====");

        int monto = 0;
        boolean retiroExitoso = billetes.actualizarBilletes(-monto);
        if (retiroExitoso) {
            operacionrealizada.setText("$" + monto);
        } else {
            operacionrealizada.setText("No hay suficientes billetes");
        }
    }

    @FXML
    public void handleTransferenciaBilletes(ActionEvent event) {
        System.out.println("==== Transferencia de Billetes ====");

        int monto = 0;
        String cuentaDestino = ""; //aqui falta el obtener cuenta de a donde vamos a tranferir prob con el login.blablabla
        //User usuarioActual = login.currentUser(); //aqui cogeremos al usuario actual 
/*
        if (usuarioActual.getSaldo() >= monto) {
            usuarioActual.setSaldo(usuarioActual.getSaldo() - monto);
                operacionrealizada.setText("$" + monto + " a cuenta " + cuentaDestino);
            } else {
                operacionrealizada.setText("Cuenta destino no encontrada.");
            }
        //} else {
            operacionrealizada.setText("Saldo insuficiente");
        }
         */
    }

    public double getSaldo() {
        return 0;
    }

    public void setSaldo(double saldoCuentaAhorro) {
    }

    public double getSaldoAhorro() {
        return 0;
    }

    public void setSaldoAhorro(double saldoCuentaAhorro) {
    }
}