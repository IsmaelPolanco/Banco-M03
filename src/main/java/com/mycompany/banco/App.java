package com.mycompany.banco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class App extends Application {

    private static Scene scene;
    static boolean cuentas;
    static String nom;
        
    static Login login;
    public static List<User> usuarioapp;
    
    public static void sesion(User pan){
        System.out.println(pan);
        login.currentUser = pan;
    }
    
    public static void logout(){
        login.currentUser = null;
    }
    
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 900, 600);
        stage.setScene(scene);
        stage.show();
    }  

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        
       login = new Login();
        launch();
    }

    public static void updateUser(User user) {
    }

}