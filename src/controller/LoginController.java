package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static Utility.Utility.*;
import static database.DBUsers.*;

public class LoginController {
    public TextField passwordField;
    public Button loginButton;
    public Button cancelButton;
    public TextField usernameField;

    public void loginButton(ActionEvent actionEvent) throws IOException {
        if(chkCredentials(usernameField,passwordField)== true){
            viewScreen(actionEvent, apptScreenURL,apptViewerTitle);
            System.out.println("Login Success");
        } else {
            alert(alertType.error,Username,"Login error");
            System.out.println("Login unsuccessful");
        }
    }
    public static void loginSuccessful(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent, apptScreenURL,apptViewerTitle);
    }
    public void cancelButton(ActionEvent actionEvent) {
        exitProgram(actionEvent);
    }
}
