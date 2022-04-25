package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

import static Utility.Utility.*;
import static database.DBAppointments.insertUser;

public class AddAppointment {
    public Label ID_addApptLabel;
    public Label Title_addApptLabel;
    public Label Description_addApptLabel;
    public Label Location_addApptLabel;
    public Label Contact_addApptLabel;
    public Label Type_addApptLabel;
    public Label StartDate_addApptLabel;
    public Label StartTime_addApptLabel;
    public Label EndDate_addApptLabel;
    public Label EndTime_addApptLabel;
    public Label CustomerID_addApptLabel;
    public Label User_addApptLabel;
    public TextField ID_addApptTextfield;
    public TextField Title_addApptTextfield;
    public TextField Description_addApptTextfield;
    public TextField Location_addApptTextfield;
    public TextField Contact_addApptTextfield;
    public TextField Type_addApptTextfield;
    public TextField CustomerID_addApptTextfield;
    public TextField UserID_addApptTextfield;
    public Label ScreenTitle_ApptLabel;
    public Button Save_addApptButton;
    public Button Cancel_addApptButton;

    public void Save_addApptButton(ActionEvent actionEvent) {
        insertUser();
    }

    public void Cancel_addApptButton(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,apptScreenURL,apptViewerTitle);
    }
}
