package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Countries;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static model.Lists.*;
import static utility.Utility.*;
import static utility.Validator.*;

public class ModifyCustomer {
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
        Countries c = (Countries) Country_Combo.getSelectionModel().getSelectedItem();
        int country_ID = c.getCountry_ID();
        Region_Combo.setItems(searchCountries(country_ID));
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
        closeScreen(actionEvent);
        // viewScreen(actionEvent,getLastURL,getLastTitle);
    }

    public void populateCustomer(Customers customer) {
        ID_Cust.setText(Integer.toString(customer.getCustomer_ID()));
        Name_Cust.setText(customer.getCustomer_Name());
        Address_Cust.setText(customer.getCustomer_Address());
        Phone_Cust.setText(customer.getCustomer_Phone());
        Postal_Cust.setText(customer.getCustomer_Postal());
        int rc1 = lookupCountry(customer.getCustomer_Div_ID());
        int cs1 = countryIndex(rc1);
        Country_Combo.setItems(getCountries());
        Country_Combo.getSelectionModel().select(cs1);
        //Region_Combo.setItems(searchCountries(rc1));
        //Region_Combo.getSelectionModel().select(regionIndex(customer.getCustomer_Div_ID(), rc1));


        int custID = Integer.parseInt(ID_Cust.getText().trim());
        ObservableList l = lookupAppts(custID);
        ApptTable_Cust.setItems(l);
        ID_Col.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        Title_Col.setCellValueFactory(new PropertyValueFactory<>("Appt_Title"));
        Location_Col.setCellValueFactory(new PropertyValueFactory<>("Appt_Location"));
        Start_Col.setCellValueFactory(new PropertyValueFactory<>("Appt_StartTime"));
        End_Col.setCellValueFactory(new PropertyValueFactory<>("Appt_EndTime"));
        Country_Combo.setItems(getCountries());
    }
}
