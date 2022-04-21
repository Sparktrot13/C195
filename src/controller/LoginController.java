package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.io.IOException;

import static Utility.Utility.*;

public class LoginController {
    public TextField passwordField;
    public Button loginButton;
    public Button cancelButton;
    public TextField usernameField;

    public void loginButton(ActionEvent actionEvent) throws IOException {
        System.out.println(usernameField.getText().trim());
        System.out.println(passwordField.getText().trim());
        System.out.println("Login Success");
        viewScreen(actionEvent, apptScreenURL);
    }
    public void cancelButton(ActionEvent actionEvent) {
        exitProgram(actionEvent);
    }
}
