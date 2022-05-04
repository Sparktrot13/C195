package controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Countries;
import model.Customers;
import model.FLDivisions;
import model.Users;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import static utility.Locales.bundle;
import static utility.Utility.*;
import static database.DBCustomers.*;
import static model.Lists.*;
import static utility.Validator.*;

public class CustomerScreen implements Initializable {
    public TableView<Customers> CustomerTable;
    public TableColumn Cust_IDColumn;
    public TableColumn Cust_NameColumn;
    public TableColumn Cust_AddressColumn;
    public TableColumn Cust_PostalColumn;
    public TableColumn Cust_PhoneColumn;
    public TableColumn Cust_RegionColumn;
    public TableColumn Cust_CountryColumn;
    public Label Cust_CountryLabel;
    public Label Cust_RegionLabel;
    public Label Cust_IDLabel;
    public Label Cust_NameLabel;
    public Label Cust_AddressLabel;
    public Label Cust_PostalLabel;
    public Label Cust_PhoneLabel;
    public TextField Cust_IDTextfield;
    public TextField Cust_NameTextfield;
    public TextField Cust_AddressTextfield;
    public TextField Cust_PostalTextfield;
    public TextField Cust_PhoneTextfield;
    public ComboBox Country_Combo;
    public ComboBox Region_Combo;
    public Button Cust_SaveButton;
    public Button Cust_UpdateButton;
    public Button Cust_CreateButton;
    public Button Cust_DeleteButton;
    public Button Cust_BackButton;
    public Label user_Label;
    public ComboBox User_Combo;

    public void Save_CustomerButton(ActionEvent actionEvent) {
        try{
            chkCustomerBlank(Cust_NameTextfield,Cust_AddressTextfield,Cust_PhoneTextfield,Cust_PostalTextfield,Region_Combo,Country_Combo);
            String name = Cust_NameTextfield.getText().trim();
            String address = Cust_AddressTextfield.getText().trim();
            String postal = Cust_PostalTextfield.getText().trim();
            String phone = Cust_PhoneColumn.getText().trim();
            Timestamp created = Timestamp.valueOf(LocalDateTime.now());
            String creator = currentUser.getUser_Name();
            Timestamp updated = Timestamp.valueOf(LocalDateTime.now());
            String updater = currentUser.getUser_Name();
            int divID = ((FLDivisions) Region_Combo.getSelectionModel().getSelectedItem()).getDiv_ID();
            insertCustomer(name,address,postal,phone,created,creator,updated,updater,divID);

        } catch (NumberFormatException e){
            System.out.println(e);
            alert(alertType.error,errorsFound.concat(errors.toString()),"Error");
        }
    }

    public void Update_CustomerButton(ActionEvent actionEvent) throws IOException {
        getLastURL = customerScreenURL;
        getLastTitle = customerTitle;
        sendCust(CustomerTable,actionEvent);
    }

    public void Create_CustomerApptButton(ActionEvent actionEvent) throws IOException {
        Customers c = CustomerTable.getSelectionModel().getSelectedItem();
        if (c == null) {
            alert(alertType.error, selectionError, "Selection Error");
        } else {
            int index = lookupCustomer(c.getCustomer_ID());
            sendCustAppt(index);
        }
        // ObservableList l = lookupAppts(chkID); ApptTable_Cust.setItems(l);
    }

    public void Delete_CustomerButton(ActionEvent actionEvent) {
        Customers c = (Customers) CustomerTable.getSelectionModel().getSelectedItem();
        if (c == null){
            alert(alertType.error,selectionError, "Selection Error");
        } else if(lookupAppts(c.getCustomer_ID()).size()>0) {
            alert(alertType.error, c.getCustomer_Name().trim() + " has " + lookupAppts(c.getCustomer_ID()).size() + customerHasAppt, customerApptError);
        } else {
            deleteCustomer(c);
            CustomerTable.setItems(getCustomers());
        }

    }

    public void BackToPrevious(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,apptScreenURL,apptViewerTitle);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CustomerTable.setItems(getAllCustomers());
        Cust_IDColumn.setCellValueFactory(new PropertyValueFactory<>("Customer_ID"));
        Cust_NameColumn.setCellValueFactory(new PropertyValueFactory<>("Customer_Name"));
        Cust_AddressColumn.setCellValueFactory(new PropertyValueFactory<>("Customer_Address"));
        Cust_PostalColumn.setCellValueFactory(new PropertyValueFactory<>("Customer_Postal"));
        Cust_PhoneColumn.setCellValueFactory(new PropertyValueFactory<>("Customer_Phone"));
        Cust_RegionColumn.setCellValueFactory(new PropertyValueFactory<>("Customer_Div_ID"));
        Country_Combo.setItems(getCountries());
    }

    public void Country_Combo(ActionEvent actionEvent) {
        Countries c = (Countries) Country_Combo.getSelectionModel().getSelectedItem();
        int country_ID = c.getCountry_ID();
        Region_Combo.setItems(searchCountries(country_ID));
        Region_Combo.getSelectionModel().selectFirst();
    }
}
