package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

import static utility.Utility.*;

public class ModifyAppointment {

    public Label ID_ModApptLabel;
    public Label Title_ModApptLabel;
    public Label Description_ModApptLabel;
    public Label Location_ModApptLabel;
    public Label Contact_ModApptLabel;
    public Label Type_ModApptLabel;
    public Label StartDate_ModApptLabel;
    public Label StartTime_ModApptLabel;
    public Label EndDate_ModApptLabel;
    public Label EndTime_ModApptLabel;
    public Label CustomerID_ModApptLabel;
    public Label User_ModApptLabel;
    public DatePicker Start_ModApptDate;
    public DatePicker End_ModApptDate;
    public ComboBox Start_ModApptCombo;
    public ComboBox End_ModApptCombo;
    public TextField ID_ModApptTextfield;
    public TextField Title_ModApptTextfield;
    public TextField Description_ModApptTextfield;
    public TextField Location_ModApptTextfield;
    public TextField Contact_ModApptTextfield;
    public TextField Type_ModApptTextfield;
    public TextField CustomerID_ModApptTextfield;
    public TextField UserID_ModApptTextfield;
    public Label ScreenTitle_ModApptLabel;
    public Button Save_modApptButton;
    public Button Cancel_ModApptButton;

    public void Save_modApptButton(ActionEvent actionEvent) {
    }

    public void Cancel_ModApptButton(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent, apptScreenURL,apptViewerTitle);
    }
}
