package utility;

import controller.ApptScreenController;
import controller.ModifyAppointment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.Appointments;
import model.Users;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;

import static database.DBUsers.*;

public class Utility {
    //Strings for alerts
    public static final String exit = "Are you sure you want to exit the program?";
    public static final String confirmation = "Confirmation Needed";
    public static final String apptDelete = "You are about to delete an appointment for ";
    public static final String confirm = "Do you wish to continue?";
    public static final String Username = "Username or password is incorrect, Please try again.";
    public static final String incorrectCred = "Invalid Credentials";
    public static final String loginBlank ="Username and password required for login, please try again.";
    public static final String loginTitle = "Credentials Required";
    public static final String chkDateInv = "Start day and time needs to be before End date and time, Please try again.";
    public static final String chkDateInv2 = "Start day and time is in the past, Please select a date and time in the future.";
    public static final String chkDateTitle = "Date Error";
    public static final String desFieldBlank = "Appointment description is required";
    public static final String locFieldBlank = "Location is required";
    public static final String typeFieldBlank = "Appointment type is required";
    public static final String startDateBlank = "Appointment start date is required";
    public static final String endDateBlank = "Appointment end date is required";
    public static final String startTimeBlank = "Appointment start Time is required";
    public static final String endTimeBlank = "Appointment end Time is required";
    public static final String contBoxBlank = "Contact's name is required";
    public static final String custBoxBlank = "Customer's name is required";
    public static final String userBoxBlank = "Name of user creating appointment required";
    public static final String deleteCustomer = "You are about to delete ";
    public static final String selectionError = "Selection needed, Please select from list to continue.";
    public static final String titleFieldBlank = "Name field is blank.";
    public static final String custNameBlank = "Customer's name required.";
    public static final String custPhoneBlank = "Customer's phone number required.";
    public static final String custAddressBlank = "Customer's address required.";
    public static final String custPostalBlank = "Customer's postal code required";
    public static final String regionBoxBlank = "State/Region box is blank";
    public static final String countryBoxBlank = "Country box is blank";
    public static final String errorsFound = "The following errors were found, please fix before saving\n\n";
    public static final String deleteAppt = "You are about to delete appointment #";


    // URL for viewScreens
    public static final String apptScreenURL = "/view/ApptScreen.fxml";
    public static final String customerScreenURL = "/view/CustomerScreen.fxml";
    public static final String addApptScreenURL = "/view/AddAppointment.fxml";
    public static final String updateApptScreenURL = "/view/ModifyAppointment.fxml";
    public static final String updateCustomerURL = "/view/ModifyCustomer.fxml";

    public static String getLastURL = null;
    public static String getLastTitle = null;

    //Screen titles
    public static final String newApptTitle = "New Appointment Scheduler";
    public static final String updateApptTitle = "Update Appointment";
    public static final String customerTitle = "Customer Information";
    public static final String apptViewerTitle = "ABC Corporation Appointments";
    public static final String customerRecordTitle = "Customer Record";

    public static LinkedList errors = new LinkedList();


    public enum alertType {confirmation, error, warning}
    public static boolean alert (alertType type, String contentText, String title){
        if (type == alertType.confirmation) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, contentText, ButtonType.CANCEL, ButtonType.YES);
            alert.setTitle(title);
            alert.setHeaderText(title);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            Optional<ButtonType> confirm = alert.showAndWait();
            return (confirm.isPresent() && confirm.get() == ButtonType.YES);
        } else if (type == alertType.error) {
            Alert alert = new Alert(Alert.AlertType.ERROR, contentText);
            alert.setTitle(title);
            alert.setHeaderText(title);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
            return false;
        } else if (type == alertType.warning) {
            Alert alert = new Alert(Alert.AlertType.WARNING, contentText);
            alert.setTitle(title);
            alert.setHeaderText(title);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
            return false;
        } else return false;
    }
    public static void exitProgram(ActionEvent actionEvent) {
        if (alert(alertType.confirmation,exit,confirmation)){
            Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
            stage.close();
        }
    }
    public static void closeScreen(ActionEvent actionEvent){
        Stage stage = (Stage) ((Button) actionEvent.getSource()).getScene().getWindow();
        stage.close();
    }
    public static void viewScreen(ActionEvent event, String url, String title) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(Objects.requireNonNull(Utility.class.getResource(url)));
        stage.setScene(new Scene(scene));
        stage.centerOnScreen();
        stage.setTitle(title);
        stage.show();
    }
    public static void refreshScreen(){
    }
    public static void newScreen(ActionEvent actionEvent, String url, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Utility.class.getResource(url));
        Scene newScene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setScene(newScene);
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        viewScreen(actionEvent,getLastURL,getLastTitle);
    }
    public static ObservableList<Users> lookupUsers (TextField username) {
        String user = username.getText().toString();
        ObservableList<Users> name = FXCollections.observableArrayList();
        ObservableList list = getAllUsers();
        for (int i = 0; i < list.size(); i++) {
            Users u = (Users) list.get(i);
            if (u.getUser_Name().toLowerCase().contains(user)) {
                name.add(u);
                System.out.println("Checks good");
            } else {
                System.out.println("Cannot find User");
            }
        } return name;
    }
    public static void sendAppt(ApptScreenController controller, TableView<Appointments> table, ActionEvent actionEvent) throws IOException {
        if (table.getSelectionModel().getSelectedItem() == null) {
            alert(alertType.error, selectionError, "error");
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(controller.getClass().getResource(updateApptScreenURL));
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            ModifyAppointment MPSController = loader.getController();
            MPSController.populateAppt(table.getSelectionModel().getSelectedItem());
            newStage.setTitle(updateApptTitle);
            newStage.setScene(newScene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();
            viewScreen(actionEvent,getLastURL,getLastTitle);

        }
    }
}

