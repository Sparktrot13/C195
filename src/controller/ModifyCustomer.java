package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

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
    }

    public void UpdateCust(ActionEvent actionEvent) {
    }

    public void CreateAppt(ActionEvent actionEvent) {
    }

    public void UpdateAppt(ActionEvent actionEvent) {
    }

    public void DeleteAppt(ActionEvent actionEvent) {
    }

    public void BackScreen(ActionEvent actionEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
