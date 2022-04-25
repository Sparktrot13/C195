package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;

import static Utility.Utility.*;
import static database.DBUsers.*;

public class LoginController {
    public TextField passwordField;
    public Button loginButton;
    public Button cancelButton;
    public TextField usernameField;

    public void loginButton(ActionEvent actionEvent) throws IOException{
        try{
            if(chkCredentials(usernameField, passwordField)) {
                System.out.println("Login Successful");
                viewScreen(actionEvent,apptScreenURL,apptViewerTitle);
            } else {
                System.out.println("Invalid credentials, Login Unsuccessful");
                alert(alertType.error,Username, incorrectCred);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void loginSuccessful(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent, apptScreenURL,apptViewerTitle);
    }
    public void cancelButton(ActionEvent actionEvent) {
        exitProgram(actionEvent);
    }
}
