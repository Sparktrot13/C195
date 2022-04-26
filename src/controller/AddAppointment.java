package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static Utility.Utility.*;
import static database.DBAppointments.*;

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
    public TextField Contact_addApptTextfield;
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

    public void Save_addApptButton(ActionEvent actionEvent) {

        String ts1 = "2022-04-25 09:55:10";
        String ts2 = "2022-04-25 10:28:28";
        String title = Title_addApptTextfield.getText().trim();
        String Des = Description_addApptTextfield.getText().trim();
        String Loc = Location_addApptTextfield.getText().trim();
        String type = Type_addApptTextfield.getText().trim();
        Timestamp start = Timestamp.valueOf(ts1);
        Timestamp end = Timestamp.valueOf(ts2);
        Timestamp create_Date = Timestamp.valueOf(ts1);
        String creator = "Me";
        Timestamp lastUpdate = Timestamp.valueOf(ts1);
        String updatedBy = "Also me";
        int cust_ID = 4;
        int user_ID = 3;
        int contact_ID = 2;
        insertAppt(title,Des,Loc,type,start,end,create_Date,creator,lastUpdate,updatedBy,cust_ID,user_ID,contact_ID);
    }

    public void Cancel_addApptButton(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,apptScreenURL,apptViewerTitle);
    }

    public void Start_addApptCombo(ActionEvent actionEvent) {
    }

    public void End_addApptCombo(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList times = FXCollections.observableArrayList();
        Time a = new Time(04, 15, 00);
        Time b = new Time(04, 30, 00);
        Time c = new Time(04, 45, 00);
        Time d = new Time(05, 00, 00);
        times.add(a);
        times.add(b);
        times.add(c);
        times.add(d);
        Start_addApptCombo.setItems(times);
    }
}
