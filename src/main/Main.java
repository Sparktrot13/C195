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
        Parent root = FXMLLoader.load(getClass().getResource("/view/loginScreen.fxml"));
        primaryStage.setTitle("Main Screen");
        primaryStage.setScene(new Scene(root, 400, 250));
        primaryStage.show();
        primaryStage.setOnCloseRequest(null);
    }
    public static void main(String[] args){
        ResourceBundle rb = ResourceBundle.getBundle("utility/prop", Locale.getDefault());
        if (Locale.getDefault().getLanguage().equals("fr")) {
            System.out.println(rb.getString("Username") + rb.getString("Password"));
        }
        startConnection();
        launch(args);
        closeConnection();
    }
    }
