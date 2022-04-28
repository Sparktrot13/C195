package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Appointments;
import model.Contacts;
import model.Customers;
import model.Users;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import static database.DBAppointments.insertAppt;
import static utility.Utility.*;
import static utility.Time.*;
import static model.Lists.*;
import static utility.Validator.chkApptBlank;
import static utility.Validator.chkDate;

public class ModifyAppointment{


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
    public DatePicker Start_addApptDate;
    public DatePicker End_addApptDate;
    public ComboBox Start_addApptCombo;
    public ComboBox End_addApptCombo;
    public TextField ID_addApptTextfield;
    public TextField Title_addApptTextfield;
    public TextField Description_addApptTextfield;
    public TextField Location_addApptTextfield;
    public TextField Type_addApptTextfield;
    public ComboBox Contact_Combo;
    public ComboBox Cust_Combo;
    public ComboBox User_Combo;
    public Label ScreenTitle_ApptLabel;
    public Button Save_addApptButton;
    public Button Cancel_addApptButton;

    public void Save_addApptButton(ActionEvent actionEvent) {
        try {
            chkApptBlank(Title_addApptTextfield, Description_addApptTextfield, Location_addApptTextfield, Type_addApptTextfield, Start_addApptDate, Start_addApptCombo, End_addApptDate, End_addApptCombo, Cust_Combo, User_Combo, Contact_Combo);
            int appt = Integer.parseInt(ID_addApptTextfield.getText());
            Timestamp created = Timestamp.valueOf(lookupAppt(appt).getAppt_Created_Date());
            String title = Title_addApptTextfield.getText().trim();
            String Des = Description_addApptTextfield.getText().trim();
            String Loc = Location_addApptTextfield.getText().trim();
            String type = Type_addApptTextfield.getText().trim();
            Timestamp start = Timestamp.valueOf(combineDateTime(Start_addApptDate,Start_addApptCombo));
            Timestamp end = Timestamp.valueOf(combineDateTime(End_addApptDate,End_addApptCombo));
            Timestamp create_Date = created;
            Timestamp lastUpdate = Timestamp.valueOf(LocalDateTime.now());
            int cust_ID = getCustID(Cust_Combo);
            int user_ID = getUserID(User_Combo);
            int contact_ID = getContactID(Contact_Combo);
            String updatedBy = getUserName(User_Combo);
            String creator = lookupAppt(appt).getAppt_Creator();
            chkDate(start,end,create_Date);
            insertAppt(title,Des,Loc,type,start,end,create_Date,creator,lastUpdate,updatedBy,cust_ID,user_ID,contact_ID);
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

    public void populateAppt(Appointments appt) {
        DateTimeFormatter combo = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime st = appt.getAppt_StartTime().toLocalTime();
        LocalTime et = appt.getAppt_EndTime().toLocalTime();
        LocalDate start = appt.getAppt_StartTime().toLocalDate();
        LocalDate end = appt.getAppt_EndTime().toLocalDate();
        int user = appt.getAppt_User_ID();
        int cust = appt.getAppt_Customer_ID();
        int contact = appt.getAppt_Contact_ID();
        Contacts c = lookupContact(contact);
        Users u = lookupUser(user);
        Customers customers = lookupCustomer(cust);
        Start_addApptCombo.setItems(getTime());
        End_addApptCombo.setItems(getTime());
        Contact_Combo.setItems(getContacts());
        User_Combo.setItems(getUsers());
        Cust_Combo.setItems(getCustomers());

        ID_addApptTextfield.setText(Integer.toString(appt.getAppointment_ID()));
        Title_addApptTextfield.setText(appt.getAppt_Title());
        Description_addApptTextfield.setText(appt.getAppt_Description());
        Location_addApptTextfield.setText(appt.getAppt_Location());
        Type_addApptTextfield.setText(appt.getAppt_Type());
        Start_addApptCombo.getSelectionModel().select(st.format(combo));
        End_addApptCombo.getSelectionModel().select(et.format(combo));
        Start_addApptDate.setValue(start);
        End_addApptDate.setValue(end);
        User_Combo.getSelectionModel().select(u);
        Contact_Combo.getSelectionModel().select(c);
        Cust_Combo.getSelectionModel().select(customers);


    }
}
