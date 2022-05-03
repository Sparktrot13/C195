package main;

import database.DBConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import static database.DBConnection.*;
import static utility.Locales.*;
import static utility.Utility.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        try {
            Locale.setDefault(new Locale("fr"));
            ResourceBundle rb = bundle();
            Parent root = FXMLLoader.load(getClass().getResource("/view/loginScreen.fxml"), rb);
            primaryStage.setTitle(rb.getString("screenTitle"));
            primaryStage.setScene(new Scene(root, 400, 250));
            primaryStage.show();
            primaryStage.setOnCloseRequest(null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        //Locale.setDefault(new Locale("fr"));
        //ResourceBundle rb = bundle();
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
