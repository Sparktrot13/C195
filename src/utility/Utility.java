package utility;

import controller.*;
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
import model.Customers;
import model.Users;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import static model.Lists.*;
import static utility.Locales.*;

public class Utility {

    public static final String exit = bundle().getString("exit"); //"Are you sure you want to exit the program?";
    public static final String confirmation = bundle().getString("confirmation"); //"Confirmation Needed";
    public static final String confirm = bundle().getString("confirm");//"Do you wish to continue?";
    public static final String Username = bundle().getString("User_name");//"Username or password is incorrect, Please try again.";
    public static final String incorrectCred = bundle().getString("incorrectCred");//"Invalid Credentials";
    public static final String loginBlank = bundle().getString("loginBlank");//"Username and password required for login, please try again.";
    public static final String loginTitle = bundle().getString("login_Title");//"Credentials Required";
    public static final String chkDateInv = bundle().getString("chkDateInv");//"Start day and time needs to be before End date and time, Please try again.";
    public static final String chkDateInv2 = bundle().getString("chkDateInv2");//"Start day and time is in the past, Please select a date and time in the future.";
    public static final String chkDateTitle = bundle().getString("chkDateTitle");//"Date Error";
    public static final String desFieldBlank = bundle().getString("desFieldBlank");//"Appointment description is required";
    public static final String locFieldBlank = bundle().getString("locFieldBlank");//"Location is required";
    public static final String typeFieldBlank = bundle().getString("typeFieldBlank");//"Appointment type is required";
    public static final String startDateBlank = bundle().getString("startDateBlank");//"Appointment start date is required";
    public static final String endDateBlank = bundle().getString("endDateBlank");//"Appointment end date is required";
    public static final String startTimeBlank = bundle().getString("startTimeBlank");//"Appointment start Time is required";
    public static final String endTimeBlank = bundle().getString("endTimeBlank");//"Appointment end Time is required";
    public static final String contBoxBlank = bundle().getString("contBoxBlank");//"Contact's name is required";
    public static final String custBoxBlank = bundle().getString("custBoxBlank");//"Customer's name is required";
    public static final String deleteCustomer = bundle().getString("deleteCustomer");//"You are about to delete ";
    public static final String selectionError = bundle().getString("selectionError");//"Selection needed, Please select from list to continue.";
    public static final String titleFieldBlank = bundle().getString("titleFieldBlank");//"Name field is blank.";
    public static final String custNameBlank = bundle().getString("custNameBlank");//"Customer's name required.";
    public static final String custPhoneBlank = bundle().getString("custPhoneBlank");//"Customer's phone number required.";
    public static final String custAddressBlank = bundle().getString("custAddressBlank");//"Customer's address required.";
    public static final String custPostalBlank = bundle().getString("custPostalBlank");//"Customer's postal code required";
    public static final String regionBoxBlank = bundle().getString("regionBoxBlank");//"State/Region box is blank";
    public static final String countryBoxBlank = bundle().getString("countryBoxBlank");//"Country box is blank";
    public static final String errorsFound = bundle().getString("errorsFound");//"The following errors were found, please fix before saving\n\n";
    public static final String deleteAppt = bundle().getString("deleteAppt");//"You are about to delete appointment #";
    public static final String customerHasAppt = bundle().getString("customerHasAppt");//" appointment, please delete all appointments before removing customer.";
    public static final String customerApptError = bundle().getString("customerApptError");//"Appointment error";
    public static final String apptStartCollides = bundle().getString("apptStartCollides");

    //need to add to bundle
    public static final String apptWarning = bundle().getString("apptWarning");
    public static final String apptWarnTitle = bundle().getString("apptWarnTitle");
    public static final String noApptWaring = bundle().getString("noApptWarning");



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

    public static Users currentUser = null;
    public static void setCurrentUser(String name){
        int index = 0;
        ObservableList<Users> allUser = getUsers();
        for (Users u : allUser) {
            if (u.getUser_Name().trim().equals(name.trim())) {
                index = allUser.indexOf(u);
            }
        }
        currentUser = getUsers().get(index);
        if (currentUser == null){
            System.out.println("currentUser is null");
        } else {
            System.out.println("welcome " + currentUser.getUser_Name() + ". Lets get to work!");
            System.out.println("User ID is " + currentUser.getUser_ID());
        }
    }
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
        Parent scene = FXMLLoader.load(Objects.requireNonNull(Utility.class.getResource(url)), bundle());
        stage.setScene(new Scene(scene));
        stage.centerOnScreen();
        stage.setTitle(title);
        stage.show();
    }
    public static void newScreen(ActionEvent actionEvent, String url, String title) throws IOException {
        Scene newScene = new Scene(FXMLLoader.load(Objects.requireNonNull(Utility.class.getResource(url)), bundle()));
        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setScene(newScene);
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        viewScreen(actionEvent,getLastURL,getLastTitle);
    }
    public static void sendAppt(TableView<Appointments> table, ActionEvent actionEvent) throws IOException {
        if (table.getSelectionModel().getSelectedItem() == null) {
            alert(alertType.error, selectionError, "error");
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Utility.class.getResource(updateApptScreenURL));
            loader.setResources(bundle());
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
    public static void sendApptCust(TableView<Appointments> table, ActionEvent actionEvent, int custID) throws IOException {
        if (table.getSelectionModel().getSelectedItem() == null) {
            alert(alertType.error, selectionError, "error");
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Utility.class.getResource(updateApptScreenURL));
            loader.setResources(bundle());
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            ModifyAppointment MPSController = loader.getController();
            MPSController.populateAppt(table.getSelectionModel().getSelectedItem());
            newStage.setTitle(updateApptTitle);
            newStage.setScene(newScene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();
            table.setItems(lookupAppts(custID));


        }
    }
    public static void sendCust(TableView<Customers> table, ActionEvent actionEvent) throws IOException {
        if (table.getSelectionModel().getSelectedItem() == null) {
            alert(alertType.error, selectionError, "error");
        } else {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Utility.class.getResource(updateCustomerURL));
            loader.setResources(bundle());
            Scene newScene = new Scene(loader.load());
            Stage newStage = new Stage();
            ModifyCustomer MPSController = loader.getController();
            MPSController.populateCustomer(table.getSelectionModel().getSelectedItem());
            newStage.setTitle(customerRecordTitle);
            newStage.setScene(newScene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();
            viewScreen(actionEvent,getLastURL,getLastTitle);

        }
    }
    public static void sendCustAppt(int CustID) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Utility.class.getResource(addApptScreenURL));
        loader.setResources(bundle());
        Scene newScene = new Scene(loader.load());
        Stage newStage = new Stage();
        AddAppointment MPSController = loader.getController();
        MPSController.populateCustomer(CustID);
            newStage.setTitle(customerRecordTitle);
            newStage.setScene(newScene);
            newStage.initModality(Modality.APPLICATION_MODAL);
            newStage.showAndWait();
        }
        public static ObservableList<Appointments> checkAppt(){
            LocalDateTime ldt = LocalDateTime.now();
            ObservableList<Appointments> upcoming = FXCollections.observableArrayList();
            ObservableList<Appointments> allAppts = getAppts();
            for (Appointments a : allAppts){
                if (a.getAppt_StartTime().isBefore(ldt.plusMinutes(15))&& a.getAppt_StartTime().isAfter(ldt.minusSeconds(1))){
                    upcoming.add(a);
                }
            } return upcoming;
        }
    }

