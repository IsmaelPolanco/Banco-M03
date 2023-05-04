
package com.mycompany.banco;

import javafx.event.ActionEvent;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Ismael Polanco
 */
public class SecondaryController {

    @FXML
    Button principal;

    @FXML
    Button ahorro;

    @FXML
    Button cerrarsesion;

    @FXML
    Label changepass;

    private boolean cuenta;

    public void initialize() {

    }

    public void seleccioncuenta(ActionEvent event) throws IOException {
        if (event.getSource() == principal) {
            cuenta = true;
            App.cuentas = cuenta;
            App.setRoot("third");
        } else if (event.getSource() == ahorro) {
            cuenta = false;
            App.cuentas = cuenta;
            App.setRoot("fourth");
        }
    }

    @FXML
    public void cerrarsesion(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }
      
    @FXML   
    private void changepassword(MouseEvent event) throws IOException {
        App.setRoot("contraseña"); 
    }
}
