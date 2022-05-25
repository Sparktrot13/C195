package controller;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;
import static model.Lists.*;

public class ContactSchedule implements Initializable {
    public ComboBox<model.Contacts> contactCombo;
    public TableView<model.Appointments> apptTable;
    public TableColumn<Object, Object> ID_appt;
    public TableColumn<Object, Object> title_Appt;
    public TableColumn<Object, Object> des_Appt;
    public TableColumn<Object, Object> type_Appt;
    public TableColumn<Object, Object> start_Appt;
    public TableColumn<Object, Object> end_Appt;
    public TableColumn<Object, Object> cust_Appt;

    public void contactCombo(ActionEvent actionEvent) {
        apptTable.setItems(contactAppts.find(contactCombo));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contactCombo.setItems(getContacts());
        contactCombo.getSelectionModel().selectFirst();
        apptTable.setItems(contactAppts.find(contactCombo));
        ID_appt.setCellValueFactory(new PropertyValueFactory<>("Appointment_ID"));
        title_Appt.setCellValueFactory(new PropertyValueFactory<>("Appt_Title"));
        des_Appt.setCellValueFactory(new PropertyValueFactory<>("Appt_Description"));
        type_Appt.setCellValueFactory(new PropertyValueFactory<>("Appt_Type"));
        start_Appt.setCellValueFactory(new PropertyValueFactory<>("Appt_StartTime"));
        end_Appt.setCellValueFactory(new PropertyValueFactory<>("Appt_EndTime"));
        cust_Appt.setCellValueFactory(new PropertyValueFactory<>("Appt_Customer_ID"));
    }
}
