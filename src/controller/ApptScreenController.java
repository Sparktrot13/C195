package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static Utility.Utility.*;
import static database.DBConnection.*;
import static database.DBAppointments.*;

public class ApptScreenController implements Initializable {
    public TableColumn Appt_IDColumn;
    public TableColumn Appt_TitleColumn;
    public TableColumn Appt_DescriptionColumn;
    public TableColumn Appt_LocationColumn;
    public TableColumn Appt_ContactColumn;
    public TableColumn Appt_TypeColumn;
    public TableColumn Appt_StartColumn;
    public TableColumn Appt_EndColumn;
    public TableColumn Appt_CustomerColumn;
    public TableColumn Appt_UserColumn;
    public DatePicker Appt_DatePicker;
    public RadioButton Appt_AllRadio;
    public ToggleGroup Appt_Selections;
    public RadioButton Appt_MonthRadio;
    public RadioButton Appt_WeekRadio;
    public Button NewAppt;
    public Button UpdateAppt;
    public Button DeleteAppt;
    public Button CustomerAppt;
    public Button ExitAppt;
    public MenuBar Appt_MenuBar;
    public TableView ApptTable;

    public void AllRadio_Appt(ActionEvent actionEvent) {
    }

    public void MonthRadio_Appt(ActionEvent actionEvent) {
    }

    public void WeekRadio_Appt(ActionEvent actionEvent) {
    }

    public void New_Appt(ActionEvent actionEvent) throws IOException {
        newScreen(actionEvent,addApptScreenURL, newApptTitle);
    }

    public void Update_Appt(ActionEvent actionEvent) throws IOException {
        newScreen(actionEvent,updateApptScreenURL,updateApptTitle);
    }

    public void Delete_Appt(ActionEvent actionEvent) {
        alert(alertType.confirmation,apptDelete + "Selected Appointment" + ". " + confirm,confirmation);
        System.out.println("Delete confirmed");
    }

    public void Customer_Appt(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,customerScreenURL,customerTitle);
    }

    public void Appt_Exit(ActionEvent actionEvent) {
        exitProgram(actionEvent);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ApptTable.setItems(getAllAppointments());
        Appt_IDColumn.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        Appt_TitleColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Title"));
        Appt_DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Description"));
        Appt_LocationColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Location"));
        Appt_TypeColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Type"));



    }
}
