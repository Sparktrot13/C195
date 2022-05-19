package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ResourceBundle;

import static utility.Utility.*;
import static utility.Time.*;

import static model.Lists.*;
import static utility.Validator.*;
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
    public TextField ID_addApptTextfield;
    public TextField Title_addApptTextfield;
    public TextField Description_addApptTextfield;
    public TextField Location_addApptTextfield;
    public TextField Type_addApptTextfield;
    public Label ScreenTitle_ApptLabel;
    public Button Save_addApptButton;
    public Button Cancel_addApptButton;
    public DatePicker Start_addApptDate;
    public DatePicker End_addApptDate;
    public ComboBox Start_addApptCombo;
    public ComboBox End_addApptCombo;
    public ComboBox Contact_Combo;
    public ComboBox Cust_Combo;

    public void Save_addApptButton(ActionEvent actionEvent) {
        try {
            chkApptBlank(Title_addApptTextfield, Description_addApptTextfield, Location_addApptTextfield, Type_addApptTextfield, Start_addApptDate, Start_addApptCombo, End_addApptDate, End_addApptCombo, Cust_Combo, Contact_Combo);
            String title = Title_addApptTextfield.getText().trim();
            String Des = Description_addApptTextfield.getText().trim();
            String Loc = Location_addApptTextfield.getText().trim();
            String type = Type_addApptTextfield.getText().trim();
            Timestamp start = convertTime(combineDateTime(Start_addApptDate,Start_addApptCombo), ZoneId.systemDefault(),ZoneId.of("UTC"));
            Timestamp end = convertTime(combineDateTime(End_addApptDate,End_addApptCombo),ZoneId.systemDefault(),ZoneId.of("UTC"));
            Timestamp create_Date = Timestamp.valueOf(LocalDateTime.now());
            Timestamp lastUpdate = Timestamp.valueOf(LocalDateTime.now());
            int cust_ID = getCustID(Cust_Combo);
            int user_ID = currentUser.getUser_ID();
            int contact_ID = getContactID(Contact_Combo);
            String creator = currentUser.getUser_Name();
            if (!chkCollision(cust_ID, combineDateTime(Start_addApptDate,Start_addApptCombo),combineDateTime(End_addApptDate,End_addApptCombo))){
                errors.add(lookupCust(cust_ID) + " " + apptStartCollides);
                throw new NumberFormatException();
            }
            chkDate(start,end,create_Date);
            insertAppt(title,Des,Loc,type,start,end,create_Date,creator,lastUpdate,creator,cust_ID,user_ID,contact_ID);
            getAppts();
            closeScreen(actionEvent);
        } catch (NumberFormatException d){
            System.out.println(d);
            alert(alertType.error,errorsFound.concat(errors.toString()),"Error");
        }
    }


    public void Cancel_addApptButton(ActionEvent actionEvent) throws IOException {
        closeScreen(actionEvent);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Start_addApptCombo.setItems(getBusinessHours());
        End_addApptCombo.setItems(getBusinessHours());
        Contact_Combo.setItems(getContacts());
        Cust_Combo.setItems(getCustomers());

    }

    public void populateCustomer(int Index) {
        Cust_Combo.getSelectionModel().select(Index);
    }

    public void StartAppt_Combo(ActionEvent actionEvent) {
        LocalTime start = LocalTime.parse(Start_addApptCombo.getSelectionModel().getSelectedItem().toString());
        if(End_addApptCombo.getSelectionModel().getSelectedItem()==null){
            End_addApptCombo.getSelectionModel().select(lookupTime(start.plusMinutes(15)));
        } else if(LocalTime.parse(End_addApptCombo.getSelectionModel().getSelectedItem().toString()).isBefore(start.plusMinutes(1))){
            End_addApptCombo.getSelectionModel().select(lookupTime(LocalTime.parse(Start_addApptCombo.getSelectionModel().getSelectedItem().toString()).plusMinutes(15)));
        }
    }

    public void ApptStart_Date(ActionEvent actionEvent) {
        if(End_addApptDate.getValue() == null||End_addApptDate.getValue().isBefore(Start_addApptDate.getValue())){
            End_addApptDate.setValue(Start_addApptDate.getValue());
        }
    }
}
