package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static utility.Utility.*;
import static database.DBCustomers.*;
import static model.Lists.*;

public class CustomerScreen implements Initializable {
    public TableView CustomerTable;
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

    public void Save_CustomerButton(ActionEvent actionEvent) {
    }

    public void Update_CustomerButton(ActionEvent actionEvent) throws IOException {
        getLastURL = customerScreenURL;
        getLastTitle = customerTitle;
        viewScreen(actionEvent,updateCustomerURL,customerRecordTitle);
    }

    public void Create_CustomerApptButton(ActionEvent actionEvent) {
    }

    public void Delete_CustomerButton(ActionEvent actionEvent) {
        Customers c = (Customers) CustomerTable.getSelectionModel().getSelectedItem();
        if (c == null){
            alert(alertType.error,selectionError, "Selection Error");
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
        Cust_CountryColumn.setText("Country");

        Country_Combo.setItems(getCountries());
    }

    public void Country_Combo(ActionEvent actionEvent) {
        Region_Combo.setItems(searchCountries(Country_Combo));
        Region_Combo.getSelectionModel().selectFirst();
    }
}
