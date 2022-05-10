package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.time.ZoneId;
import java.util.Locale;
import java.util.Objects;
import java.util.ResourceBundle;

import static database.DBConnection.*;
import static utility.Locales.*;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Locale.setDefault(new Locale("en"));
            ResourceBundle rb = bundle();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/loginScreen.fxml")), rb);
            primaryStage.setTitle(rb.getString("screenTitle"));
            primaryStage.setScene(new Scene(root, 400, 250));
            primaryStage.show();
            primaryStage.setOnCloseRequest(null);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        if (Locale.getDefault().getLanguage().equals("fr")) {
            System.out.println("fr");
        } else {
            System.out.println("other");
        }
        ZoneId.getAvailableZoneIds().forEach(System.out::println);
        startConnection();
        launch(args);
        closeConnection();
    }

    }
