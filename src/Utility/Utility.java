package Utility;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Optional;
import java.util.Queue;
import static database.DBUsers.*;

public class Utility {
    //Strings for alerts
    public static final String exit = "Are you sure you want to exit the program?";
    public static final String confirmation = "Confirmation Needed";
    public static final String apptDelete = "You are about to delete an appointment for ";
    public static final String confirm = "Do you wish to continue?";


    // URL for viewScreens
    public static final String apptScreenURL = "/view/ApptScreen.fxml";
    public static final String customerScreenURL = "/view/CustomerScreen.fxml";
    public static final String addApptScreenURL = "/view/AddAppointment.fxml";
    public static final String updateApptScreenURL = "/view/ModifyAppointment.fxml";

    //Screen titles
    public static final String newApptTitle = "New Appointment Scheduler";
    public static final String updateApptTitle = "Update Appointment";
    public static final String customerTitle = "Customer Information";
    public static final String apptViewerTitle = "ABC Corporation Appointments";


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
    public static void viewScreen(ActionEvent event, String url, String title) throws IOException {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        Parent scene = FXMLLoader.load(Objects.requireNonNull(Utility.class.getResource(url)));
        stage.setScene(new Scene(scene));
        stage.centerOnScreen();
        stage.setTitle(title);
        stage.show();
    }
    public static void newScreen(ActionEvent event, String url, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(Utility.class.getResource(url));
        Scene newScene = new Scene(fxmlLoader.load());
        Stage newStage = new Stage();
        newStage.setTitle(title);
        newStage.setScene(newScene);
        newStage.show();
    }
    public static void Validate_Username (TextField username){
        ObservableList list = getAllUsers();
        String check = username.getText().trim();
        if (list.contains(PropertyValueFactory<>("User_Name")))
    }
}
