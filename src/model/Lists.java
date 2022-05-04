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
import static utility.Time.*;

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
    public static ObservableList<FLDivisions> searchCountries(int country_ID){
        ObservableList<FLDivisions> firstLevel = FXCollections.observableArrayList();
        ObservableList<FLDivisions> gottenList = getDivisions();
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
    public static ObservableList<Appointments> getMonthAppts() {
        ObservableList<Appointments> thisMonth = FXCollections.observableArrayList();
        for (Appointments a : getAppts()) {
            if (getMonth(a.getAppt_StartTime())) {
                thisMonth.add(a);
            }
        } return thisMonth;
    }
    public static ObservableList<Appointments> getWeekAppts() {
        ObservableList<Appointments> thisWeek = FXCollections.observableArrayList();
        for (Appointments a : getAppts()) {
            if (getWeek(a.getAppt_StartTime())) {
                thisWeek.add(a);
            }
        } return thisWeek;
    }
}
