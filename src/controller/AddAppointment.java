package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static utility.Utility.*;
import static database.DBAppointments.*;
import static utility.Time.*;
import static database.DBContacts.*;

public class AddAppointment implements Initializable {
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
    public TextField Type_addApptTextfield;
    public TextField CustomerID_addApptTextfield;
    public TextField UserID_addApptTextfield;
    public Label ScreenTitle_ApptLabel;
    public Button Save_addApptButton;
    public Button Cancel_addApptButton;
    public DatePicker Start_addApptDate;
    public DatePicker End_addApptDate;
    public ComboBox Start_addApptCombo;
    public ComboBox End_addApptCombo;
    public ComboBox Contact_Combo;

    public void Save_addApptButton(ActionEvent actionEvent) {
        String title = Title_addApptTextfield.getText().trim();
        String Des = Description_addApptTextfield.getText().trim();
        String Loc = Location_addApptTextfield.getText().trim();
        String type = Type_addApptTextfield.getText().trim();
        Timestamp start = Timestamp.valueOf(combineDateTime(Start_addApptDate,Start_addApptCombo));
        Timestamp end = Timestamp.valueOf(combineDateTime(End_addApptDate,End_addApptCombo));
        Timestamp create_Date = Timestamp.valueOf(LocalDateTime.now());
        String creator = "Me";
        Timestamp lastUpdate = Timestamp.valueOf(LocalDateTime.now());
        String updatedBy = "Also me";
        int cust_ID = 4;
        int user_ID = 3;
        int contact_ID = 2;
        insertAppt(title,Des,Loc,type,start,end,create_Date,creator,lastUpdate,updatedBy,cust_ID,user_ID,contact_ID);
    }

    public void Cancel_addApptButton(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,apptScreenURL,apptViewerTitle);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Start_addApptCombo.setItems(getTime());
        Start_addApptCombo.getSelectionModel().selectFirst();
        End_addApptCombo.setItems(getTime());
        End_addApptCombo.getSelectionModel().selectFirst();
        Contact_Combo.setItems(getContacts());

    }
}
