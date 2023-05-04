package com.mycompany.banco;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/*
 * 
 * @author Ismael Polanco
 */
public class CambiarContrasena {

    @FXML
    private TextField newPass;

    @FXML
    private TextField passantigua;

    @FXML
    private TextField verificarPass;

    @FXML
    private Button volver;

    @FXML
    private Button save;
    
    User currentUser = App.login.currentUser;


    @FXML
    public void handleVolverButton() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    public void handleGuardarButton(ActionEvent event) {
        String nuevaPass = newPass.getText();

        if (nuevaPass.length() < 8 ) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("La contraseña debe tener al menos 8 caracteres.");
            alert.showAndWait();
            return;
        }
        
        boolean exito = cambiarContrasena();
        if (exito) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Contraseña cambiada");
            alert.setHeaderText(null);
            alert.setContentText("Contraseña cambiada con éxito");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Error al cambiar la contraseña. Verifica que la contraseña antigua sea correcta y que la nueva contraseña sea diferente a la anterior.");
            alert.showAndWait();
        }
    }

    private boolean cambiarContrasena() {
        String contrAntigua = contraantigua();

        if (contrAntigua.equals(passantigua.getText()) && !newPass.getText().equals(passantigua.getText())) {
            boolean exito = guardarNuevaContrasena(newPass.getText());
            if (exito) {
                currentUser.setPassword(newPass.getText());
            }
            return exito;
        } else {
            return false;
        }
    }

    private boolean guardarNuevaContrasena(String newPass) {
    boolean exito = false;
    List<User> users = App.login.users;
    for (User user : users ) {
        if (user.getUsername().equals(currentUser.getUsername())) {
            user.setPassword(newPass);//aquí se actualiza la contraseña
            currentUser.setPassword(newPass);
            exito = true;
            System.out.println(user.getPassword());
            break;
        }
    }    
    return exito;
    }
    
    private String contraantigua() {
        String contrAntigua = App.login.currentUser.getPassword();//aqui se obtiene la contra del usu en cuestion
        return contrAntigua;
    }
}
