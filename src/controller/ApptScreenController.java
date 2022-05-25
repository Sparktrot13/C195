package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Appointments;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static model.Lists.*;
import static utility.Utility.*;
import static database.DBAppointments.*;

public class ApptScreenController implements Initializable {
    public TableColumn<Object, Object> Appt_IDColumn;
    public TableColumn<Object, Object> Appt_TitleColumn;
    public TableColumn<Object, Object> Appt_DescriptionColumn;
    public TableColumn<Object, Object> Appt_LocationColumn;
    public TableColumn<Object, Object> Appt_ContactColumn;
    public TableColumn<Object, Object> Appt_TypeColumn;
    public TableColumn<Object, Object> Appt_StartColumn;
    public TableColumn<Object, Object> Appt_EndColumn;
    public TableColumn<Object, Object> Appt_CustomerColumn;
    public TableColumn<Object, Object> Appt_UserColumn;
    public RadioButton Appt_AllRadio;
    public ToggleGroup Appt_Selections;
    public RadioButton Appt_MonthRadio;
    public RadioButton Appt_WeekRadio;
    public Button NewAppt;
    public Button UpdateAppt;
    public Button DeleteAppt;
    public Button CustomerAppt;
    public Button ExitAppt;
    public TableView<model.Appointments> ApptTable;
    public ComboBox<String> typeCombo;
    public ComboBox<java.time.Month> monthCombo;
    public Button contactsReport;
    public Label matches_Appt;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeCombo.setItems(getType());
        monthCombo.setItems(getAllMonths());
        matches_Appt.setText("0");
        ApptTable.setItems(getAllAppointments());
        Appt_IDColumn.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        Appt_TitleColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Title"));
        Appt_DescriptionColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Description"));
        Appt_LocationColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Location"));
        Appt_TypeColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Type"));
        Appt_ContactColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Contact_ID"));
        Appt_StartColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_StartTime"));
        Appt_EndColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_EndTime"));
        Appt_CustomerColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_Customer_ID"));
        Appt_UserColumn.setCellValueFactory(new PropertyValueFactory<>("Appt_User_ID"));
    }

    /** Refreshes appointment table with filtered list of appointments.
     *
     */
    public void AllRadio_Appt() {
        ApptTable.setItems(getAppts());
    }

    /** Refreshes appointment table with filtered list of appointments.
     *
     */
    public void MonthRadio_Appt() {
        ApptTable.setItems(getMonthAppts());
    }

    /** Refreshes appointment table with filtered list of appointments.
     *
     */
    public void WeekRadio_Appt() {
        ApptTable.setItems(getWeekAppts());
    }

    /** Opens window to create a new appointment.
     *
     * @param actionEvent actionEvent is used to trigger the newScreen method.
     * @throws IOException throws exception for loader.
     */
    public void New_Appt(ActionEvent actionEvent) throws IOException {
        getLastURL = apptScreenURL;
        getLastTitle = "Main Screen";
        newScreen(actionEvent,addApptScreenURL, newApptTitle);
    }

    /**Takes table selection and sends appointment information to a separate update screen.
     *
     * @param actionEvent actionEvent is used to trigger the newScreen method.
     * @throws IOException throws exception for loader.
     */
    public void Update_Appt(ActionEvent actionEvent) throws IOException {
            getLastURL = apptScreenURL;
            getLastTitle = "Main Screen";
            sendAppt(ApptTable,actionEvent);
    }

    /** Verifies user selected an appointment and calls deleteAppt method.
     *
     */
    public void Delete_Appt() {
        Appointments a = ApptTable.getSelectionModel().getSelectedItem();
        if (a == null){
            alert(alertType.error,selectionError, "Selection Error");
        } else {
            deleteAppt(a);
            ApptTable.setItems(getAppts());
        }
    }

    /** Send user to Customer screen.
     *
     * @param actionEvent actionEvent triggers viewScreen method
     * @throws IOException throws exception for loader.
     */
    public void Customer_Appt(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,customerScreenURL,customerTitle);
    }

    /**
     *
     * @param actionEvent
     */
    public void Appt_Exit(ActionEvent actionEvent) {
        exitProgram(actionEvent);
    }

    public void contactsReport(ActionEvent actionEvent) throws IOException {
        viewScreen(actionEvent,contactReport,contactTitle);
    }

    /**
     *
     */
    public void typeCombo() {
        if(monthCombo.getSelectionModel().getSelectedItem() == null){
            matches_Appt.setText(String.valueOf(chkByType(typeCombo)));
            System.out.println("Month is null");
        } else {
            matches_Appt.setText(String.valueOf(chkByBoth(typeCombo, monthCombo)));
            System.out.println("month and type are good");
        }
    }

    /**
     *
     */
    public void monthCombo() {
        if(typeCombo.getSelectionModel().getSelectedItem() == null){
            matches_Appt.setText(String.valueOf(chkByMonth(monthCombo)));
            System.out.println("Type is null");
        } else {
            matches_Appt.setText(String.valueOf(chkByBoth(typeCombo, monthCombo)));
            System.out.println("month and type are good");
        }
    }
}
