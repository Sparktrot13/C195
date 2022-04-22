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
        if(lookupUsers(usernameField)==true){
            viewScreen(actionEvent, apptScreenURL,apptViewerTitle);
            System.out.println("Login Success");
        } else {
            alert(alertType.error,Username,"Login error");
            System.out.println("Login unsuccessful");
        }


    }
    public void cancelButton(ActionEvent actionEvent) {
        exitProgram(actionEvent);
    }
}
