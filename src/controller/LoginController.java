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

    public void loginButton(ActionEvent actionEvent) throws IOException {
        if (usernameField.getText().isBlank() || (passwordField.getText().isBlank())) {
            System.out.println("Username and/or password Blank");
            alert(alertType.error, loginBlank, loginTitle);
        } else {
            try {
                if (chkCredentials(usernameField, passwordField)) {
                    System.out.println("Login Successful");
                    viewScreen(actionEvent, apptScreenURL, apptViewerTitle);
                } else {
                    System.out.println("Invalid credentials, Login Unsuccessful");
                    alert(alertType.error, Username, incorrectCred);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void cancelButton(ActionEvent actionEvent) {
        exitProgram(actionEvent);
    }
}
