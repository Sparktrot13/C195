package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import static utility.Utility.*;
import static database.DBUsers.*;

public class LoginController implements Initializable {
    public TextField passwordField;
    public Button loginButton;
    public Button cancelButton;
    public TextField usernameField;
    public Label UsernameLabel;
    public Label PasswordLabel;
    public Label TitleLabel;
    public Label LocationLabel;
    public Label ZoneLabel;

    public void loginButton(ActionEvent actionEvent) throws IOException {
        if (usernameField.getText().isBlank() || (passwordField.getText().isBlank())) {
            System.out.println("Username and/or password Blank");
            alert(alertType.error, loginBlank, loginTitle);
        } else {
            try {
                if (chkCredentials(usernameField, passwordField)) {
                    loginAttempt(usernameField, passwordField, "Successful");
                    System.out.println("Login Successful");
                    setCurrentUser(usernameField.getText().trim());
                    viewScreen(actionEvent, apptScreenURL, apptViewerTitle);
                    checkAppt();
                    if(checkAppt().size() == 0){
                        alert(alertType.warning,noApptWaring,apptWarnTitle);
                    } else {
                        alert(alertType.warning,apptWarning + checkAppt(),apptWarnTitle);
                    }
                } else {
                    loginAttempt(usernameField, passwordField, "Unsuccessful");
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ZoneId zone = ZoneId.systemDefault();
        LocalTime lt = LocalTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("h:mm");
        LocationLabel.setText(zone + ", " + lt.format(timeFormatter));
    }
}
