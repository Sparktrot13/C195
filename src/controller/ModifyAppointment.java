package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static utility.Utility.*;
import static utility.Time.*;

public class ModifyAppointment implements Initializable {

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
        closeScreen(actionEvent);
    }

    public void populateAppt(Appointments appt) {
        DateTimeFormatter combo = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime st = appt.getAppt_StartTime().toLocalTime();
        LocalTime et = appt.getAppt_EndTime().toLocalTime();
        LocalDate start = appt.getAppt_StartTime().toLocalDate();
        LocalDate end = appt.getAppt_EndTime().toLocalDate();
        ID_ModApptTextfield.setText(Integer.toString(appt.getAppointment_ID()));
        Title_ModApptTextfield.setText(appt.getAppt_Title());
        Description_ModApptTextfield.setText(appt.getAppt_Description());
        Location_ModApptTextfield.setText(appt.getAppt_Location());
        Type_ModApptTextfield.setText(appt.getAppt_Type());
        Start_ModApptCombo.setItems(getTime());
        Start_ModApptCombo.getSelectionModel().select(st.format(combo));
        End_ModApptCombo.setItems(getTime());
        End_ModApptCombo.getSelectionModel().select(et.format(combo));
        Start_ModApptDate.setValue(start);
        End_ModApptDate.setValue(end);
        //Contact_ModApptTextfield.setText(appt.getAppt_Contact_ID());

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //populateAppt();
    }
}
