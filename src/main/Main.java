package main;

import database.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Locale;
import java.util.ResourceBundle;

import static database.DBConnection.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Locale.setDefault(new Locale("fr"));
        ResourceBundle rb = ResourceBundle.getBundle("utility/propRB", Locale.getDefault());
        Parent root = FXMLLoader.load(getClass().getResource("/view/loginScreen.fxml"), rb);
        primaryStage.setTitle(rb.getString("screenTitle"));
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
        primaryStage.setOnCloseRequest(null);
    }
    public static void main(String[] args){
        //Locale.setDefault(new Locale("fr"));
        //ResourceBundle rb = ResourceBundle.getBundle("utility/propRB", Locale.getDefault());
        if (Locale.getDefault().getLanguage().equals("fr")) {
            System.out.println("fr");
            //System.out.println(rb.getString("username") + rb.getString("password"));
        } else {
            System.out.println("other");
        }
        startConnection();
        launch(args);
        closeConnection();
    }
    }
