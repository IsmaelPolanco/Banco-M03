package com.mycompany.banco;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Ismael Polanco
 */
public class Login {

    @FXML
    private Button btnLogin;

    @FXML
    private TextField txtUser;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label mensaje;

    List<User> users = new ArrayList<>();

    public User currentUser; // Campo para almacenar el usuario actual
    
    int fallos = 0;

    public void initialize() {

    }

    public Login()  {
        // Agregar usuarios permitidos
        users.add(new User("isma", "Polanco", 10000, 50000));
        users.add(new User("asier", "rodriguez", 400, 30000));
        users.add(new User("unai", "gomez", 10, 200));
    }
    
    @FXML
    public void iniciarsesion() throws IOException {
        System.out.println("Cargando correctamente");
        String username = txtUser.getText();
        String password = txtPassword.getText();
        App.nom = username;
        boolean validCredentials = false;
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                validCredentials = true;
                App.sesion(user);
                break;
            }
        }      

        if (validCredentials) {
            mensaje.setText("Credenciales válidas");
            App.setRoot("secondary");
          
        } else {
            System.out.println("Credenciales inválidas");
            mensaje.setText("Error al registrar");
            fallos++;
            
            if (fallos == 3) {
                mensaje.setText("Ha alcanzado el límite. Acceso bloqueado.");
                btnLogin.setDisable(true);
            }

        } 
    }

}
