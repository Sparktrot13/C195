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
    public static ObservableList<FLDivisions> searchCountries(int country_ID){
        ObservableList<FLDivisions> firstLevel = FXCollections.observableArrayList();
        ObservableList<FLDivisions> gottenList = getDivisions();
        //Countries country = (Countries) c.getSelectionModel().getSelectedItem();
        //int country_ID = country.getCountry_ID();
        for (FLDivisions flDivisions : gottenList) {
            if (flDivisions.getDiv_Country_ID() == country_ID) {
                firstLevel.add(flDivisions);
            }
        }
        return firstLevel;
    }
    public static int lookupCountry(int regID) {
        int C_ID = 0;
        ObservableList<FLDivisions> regions = getDivisions();
        ObservableList<FLDivisions> regList = FXCollections.observableArrayList();
        for(FLDivisions d : regions){
            if(d.getDiv_ID()== regID){
                C_ID = d.getDiv_Country_ID();
            }
        } return  C_ID;
    }
    public static int regionIndex(int regID, int cID){
        int index = 0;
        ObservableList<FLDivisions> div = searchCountries(cID);
        for(FLDivisions d : div){
            if(d.getDiv_ID()==regID){
                index = div.indexOf(d);
            }
        }return index;
    }
    public static int countryIndex(int ID){
        int index = 0;
        ObservableList<Countries> country = getAllCountries();
        for(Countries c: country){
            if(c.getCountry_ID() == ID){
                index = country.indexOf(c);
            }
        } return index;
    }

    public static String lookupCust(int ID){
        ObservableList<Customers> allCust = getCustomers();
        for (Customers customers : allCust) {
            if (customers.getCustomer_ID() == ID) {
                return customers.getCustomer_Name();
            }
        }
        return null;
    }
    public static int lookupUser(int ID){
        ObservableList<Users> allUsers = getUsers();
        for( int i = 0; i < allUsers.size(); i++){
            Users u = allUsers.get(i);
            if(u.getUser_ID() == ID){
                return allUsers.indexOf(u);
            }
        }
        return ID;
    }
    public static int findUser(String name){
        int index = 0;
        ObservableList<Users> allUsers = getUsers();
        for( int i = 0; i < allUsers.size(); i++){
            Users u = allUsers.get(i);
            if(u.getUser_Name() == name){
                index = allUsers.indexOf(u);
            }
        }
        return index;
    }
    public static int lookupCustomer(int ID){
        ObservableList<Customers> allCust = getCustomers();
        for( int i = 0; i < allCust.size(); i++){
            Customers customers = allCust.get(i);
            if(customers.getCustomer_ID() == ID){
                return allCust.indexOf(customers);
            }
        }
        return ID;
    }
    public static int lookupContact(int ID){
        ObservableList<Contacts> allContacts = getContacts();
        for( int i = 0; i < allContacts.size(); i++){
            Contacts c = allContacts.get(i);
            if(c.getContact_ID() == ID){
                return allContacts.indexOf(c);
            }
        }
        return ID;
    }
    public static ObservableList<Appointments> lookupAppts(int custID){
        ObservableList<Appointments> allAppts = getAppts();
        ObservableList<Appointments> custAppts = FXCollections.observableArrayList();
        for(Appointments a : allAppts){
            if (a.getAppt_Customer_ID() == custID){
                custAppts.add(a);
            }
        } return custAppts;
    }
}
