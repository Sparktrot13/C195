package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static model.Lists.*;
import static utility.Utility.*;
import static utility.Validator.*;

public class ModifyCustomer implements Initializable {
    public ComboBox Country_Combo;
    public ComboBox Region_Combo;
    public Label Country_Label;
    public Label Region_Label;
    public Label Postal_Label;
    public Label Address_Label;
    public Label Phone_Label;
    public Label Name_Label;
    public Label ID_Label;
    public TextField ID_Cust;
    public TextField Name_Cust;
    public TextField Phone_Cust;
    public TextField Address_Cust;
    public TextField Postal_Cust;
    public Button Update_Cust;
    public TableView ApptTable_Cust;
    public TableColumn ID_Col;
    public TableColumn Title_Col;
    public TableColumn Location_Col;
    public TableColumn Start_Col;
    public TableColumn End_Col;
    public Label TableTitle_Label;
    public Label Title_Label;
    public Button Create_Appt;
    public Button Update_Appt;
    public Button Delete_Appt;
    public Button Back_Screen;

    public void CountryCombo(ActionEvent actionEvent) {
        Region_Combo.setItems(searchCountries(Country_Combo));
        Region_Combo.getSelectionModel().selectFirst();
    }

    public void UpdateCust(ActionEvent actionEvent) {
        try{
            chkCustomerBlank(Name_Cust,Address_Cust,Phone_Cust,Postal_Cust,Region_Combo,Country_Combo);
        } catch (NumberFormatException e){
            System.out.println(e);
            alert(alertType.error,errorsFound.concat(errors.toString()),"Error");
        }
    }

    public void CreateAppt(ActionEvent actionEvent) {
    }

    public void UpdateAppt(ActionEvent actionEvent) {
    }

    public void DeleteAppt(ActionEvent actionEvent) {
    }

    public void BackScreen(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,getLastURL,getLastTitle);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApptTable_Cust.setItems(getAppts());
        ID_Col.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        Title_Col.setCellValueFactory(new PropertyValueFactory<>("Appt_Title"));
        Location_Col.setCellValueFactory(new PropertyValueFactory<>("Appt_Location"));
        Start_Col.setCellValueFactory(new PropertyValueFactory<>("Appt_StartTime"));
        End_Col.setCellValueFactory(new PropertyValueFactory<>("Appt_EndTime"));
        Country_Combo.setItems(getCountries());
    }
}
