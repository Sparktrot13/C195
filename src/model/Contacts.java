package model;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import static database.DBContacts.*;

public class Contacts {
    private int Contact_ID;
    private String Contact_Name;
    private String Contact_Email;

    public Contacts(int contact_ID, String contact_Name, String contact_Email) {
        Contact_ID = contact_ID;
        Contact_Name = contact_Name;
        Contact_Email = contact_Email;
    }

    public int getContact_ID() {
        return Contact_ID;
    }

    public void setContact_ID(int contact_ID) {
        Contact_ID = contact_ID;
    }

    public String getContact_Name() {
        return Contact_Name;
    }

    public void setContact_Name(String contact_Name) {
        Contact_Name = contact_Name;
    }

    public String getContact_Email() {
        return Contact_Email;
    }

    public void setContact_Email(String contact_Email) {
        Contact_Email = contact_Email;
    }
    public static int getContactId(ComboBox c){
        Contacts con = (Contacts) c.getSelectionModel().getSelectedItem();
        return con.Contact_ID;
    }

    @Override
    public String toString(){
        return (Contact_Name);
    }
}
