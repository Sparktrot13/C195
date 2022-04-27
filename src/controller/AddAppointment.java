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

import static model.Lists.*;
import static utility.Validator.*;

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
    public Label ScreenTitle_ApptLabel;
    public Button Save_addApptButton;
    public Button Cancel_addApptButton;
    public DatePicker Start_addApptDate;
    public DatePicker End_addApptDate;
    public ComboBox Start_addApptCombo;
    public ComboBox End_addApptCombo;
    public ComboBox Contact_Combo;
    public ComboBox User_Combo;
    public ComboBox Cust_Combo;

    /*public static void verifyFields(TextField title, TextField des, TextField loc, TextField type, DatePicker start,ComboBox st, DatePicker end,ComboBox et, ComboBox cust,ComboBox user, ComboBox contact){
        chkBlank(title,titleBlank);
        chkBlank(des,desBlank);
        chkBlank(loc,locBlank);
        chkBlank(type,typeBlank);
        chkDatePicker(start, startDateBlank);
        chkDatePicker(end, endDateBlank);
        chkComboBoxBlank(st, startTimeBlank);
        chkComboBoxBlank(et, endTimeBlank);
        chkComboBoxBlank(cust,customerBlank);
        chkComboBoxBlank(user, userBlank);
        chkComboBoxBlank(contact, contactBlank);
        alert(alertType.error,"The following errors were found, please fix before saving\n" + errors,"Error");*/

    public void Save_addApptButton(ActionEvent actionEvent) {
        try {
            chkAppointments(Start_addApptDate,End_addApptDate, Start_addApptCombo,End_addApptCombo);
            //verifyFields(Title_addApptTextfield, Description_addApptTextfield, Location_addApptTextfield, Type_addApptTextfield, Start_addApptDate, Start_addApptCombo, End_addApptDate, End_addApptCombo, Cust_Combo, User_Combo, Contact_Combo);
        } catch (Exception d){
            d.printStackTrace();
            alert(alertType.error,"The following errors were found, please fix before saving\n\n".concat(errors.toString()),"Error");
        }
        /*String title = Title_addApptTextfield.getText().trim();
        String Des = Description_addApptTextfield.getText().trim();
        String Loc = Location_addApptTextfield.getText().trim();
        String type = Type_addApptTextfield.getText().trim();
        Timestamp start = Timestamp.valueOf(combineDateTime(Start_addApptDate,Start_addApptCombo));
        Timestamp end = Timestamp.valueOf(combineDateTime(End_addApptDate,End_addApptCombo));
        Timestamp create_Date = Timestamp.valueOf(LocalDateTime.now());
        Timestamp lastUpdate = Timestamp.valueOf(LocalDateTime.now());
        int cust_ID = getCustID(Cust_Combo);
        int user_ID = getUserID(User_Combo);
        int contact_ID = getContactID(Contact_Combo);
        String updatedBy = getUserName(User_Combo);
        String creator = getUserName(User_Combo);
        insertAppt(title,Des,Loc,type,start,end,create_Date,creator,lastUpdate,updatedBy,cust_ID,user_ID,contact_ID);
    */
    }


    public void Cancel_addApptButton(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,apptScreenURL,apptViewerTitle);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Start_addApptCombo.setItems(getTime());
        End_addApptCombo.setItems(getTime());
        Contact_Combo.setItems(getContacts());
        User_Combo.setItems(getUsers());
        Cust_Combo.setItems(getCustomers());

    }
}
