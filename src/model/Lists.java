package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import static database.DBAppointments.*;
import static database.DBUsers.*;
import static database.DBContacts.*;
import static database.DBCustomers.*;
import static database.DBCountries.*;
import static database.DBFLDivision.*;

public class Lists {
    public static ObservableList<Appointments> getAppts(){
        return getAllAppointments();
    }
    public static ObservableList<Users> getUsers(){
        return getAllUsers();
    }
    public static ObservableList<Contacts> getContacts(){
        return getAllContacts();
    }
    public static ObservableList<Customers> getCustomers(){
        return getAllCustomers();
    }
    public static ObservableList<Countries> getCountries(){
        return getAllCountries();
    }
    public static ObservableList<FLDivisions> getDivisions(){
        return getAllFLDivision();
    }
    public static int getContactID(ComboBox c){
        Contacts contacts = (Contacts) c.getSelectionModel().getSelectedItem();
        return contacts.getContact_ID();
    }
    public static int getCustID(ComboBox c){
        Customers cust = (Customers) c.getSelectionModel().getSelectedItem();
        return cust.getCustomer_ID();
    }
    public static int getUserID(ComboBox c){
        Users user = (Users) c.getSelectionModel().getSelectedItem();
        return user.getUser_ID();
    }
    public static String getUserName(ComboBox c){
        Users user = (Users) c.getSelectionModel().getSelectedItem();
        return user.getUser_Name();
    }
    public static ObservableList<FLDivisions> searchCountries(ComboBox c){
        ObservableList<FLDivisions> firstLevel = FXCollections.observableArrayList();
        ObservableList<FLDivisions> gottenList = getDivisions();
        Countries country = (Countries) c.getSelectionModel().getSelectedItem();
        int country_ID = country.getCountry_ID();
        for(int i = 0; i<gottenList.size(); i++){
            if(gottenList.get(i).getDiv_Country_ID() == country_ID){
                firstLevel.add(gottenList.get(i));
                continue;
            }
        } return firstLevel;
    }
    public static String lookupCust(int ID){
        ObservableList<Customers> allCust = getCustomers();
        for( int i = 0; i < allCust.size(); i++){
            Customers customers = allCust.get(i);
            if(customers.getCustomer_ID() == ID){
                return customers.getCustomer_Name();
            }
        }
        return null;
    }
}
