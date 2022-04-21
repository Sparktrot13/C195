package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.io.IOException;

import static Utility.Utility.*;

public class CustomerScreen {
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
    public ComboBox Cust_CountryComboBox;
    public ComboBox Cust_RegionComboBox;
    public Button Cust_SaveButton;
    public Button Cust_UpdateButton;
    public Button Cust_CreateButton;
    public Button Cust_DeleteButton;
    public Button Cust_BackButton;

    public void Save_CustomerButton(ActionEvent actionEvent) {
    }

    public void Update_CustomerButton(ActionEvent actionEvent) {
    }

    public void Create_CustomerApptButton(ActionEvent actionEvent) {
    }

    public void Delete_CustomerButton(ActionEvent actionEvent) {
    }

    public void BackToPrevious(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,apptScreenURL);
    }
}
