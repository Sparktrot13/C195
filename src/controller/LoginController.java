package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import utility.Time;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.TimeZone;

import static utility.Locales.bundle;
import static utility.Utility.*;
import static database.DBUsers.*;
import static main.Main.*;

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
        //TimeZone tz = TimeZone.getTimeZone(zone);
        //ZoneId zone = TimeZone.getDefault().toZoneId();
        LocationLabel.setText(zone.toString() + ", " + lt.format(timeFormatter));
    }
}
