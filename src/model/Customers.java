package model;

import java.time.format.DateTimeFormatter;

public class Customers {
    private int Customer_ID;
    private String Customer_Name;
    private String Customer_Address;
    private String Customer_Postal;
    private String Customer_Phone;
    private DateTimeFormatter Customer_Created;
    private String Customer_Created_By;
    private DateTimeFormatter TimeStamp;
    private String Customer_Updated_by;
    private int Customer_Div_ID;

    public Customers(int customer_ID, String customer_Name, String customer_Address, String customer_Postal, String customer_Phone, DateTimeFormatter customer_Created, String customer_Created_By, DateTimeFormatter timeStamp, String customer_Updated_by, int customer_Div_ID) {
        Customer_ID = customer_ID;
        Customer_Name = customer_Name;
        Customer_Address = customer_Address;
        Customer_Postal = customer_Postal;
        Customer_Phone = customer_Phone;
        Customer_Created = customer_Created;
        Customer_Created_By = customer_Created_By;
        TimeStamp = timeStamp;
        Customer_Updated_by = customer_Updated_by;
        Customer_Div_ID = customer_Div_ID;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public String getCustomer_Name() {
        return Customer_Name;
    }

    public void setCustomer_Name(String customer_Name) {
        Customer_Name = customer_Name;
    }

    public String getCustomer_Address() {
        return Customer_Address;
    }

    public void setCustomer_Address(String customer_Address) {
        Customer_Address = customer_Address;
    }

    public String getCustomer_Postal() {
        return Customer_Postal;
    }

    public void setCustomer_Postal(String customer_Postal) {
        Customer_Postal = customer_Postal;
    }

    public String getCustomer_Phone() {
        return Customer_Phone;
    }

    public void setCustomer_Phone(String customer_Phone) {
        Customer_Phone = customer_Phone;
    }

    public DateTimeFormatter getCustomer_Created() {
        return Customer_Created;
    }

    public void setCustomer_Created(DateTimeFormatter customer_Created) {
        Customer_Created = customer_Created;
    }

    public String getCustomer_Created_By() {
        return Customer_Created_By;
    }

    public void setCustomer_Created_By(String customer_Created_By) {
        Customer_Created_By = customer_Created_By;
    }

    public DateTimeFormatter getTimeStamp() {
        return TimeStamp;
    }

    public void setTimeStamp(DateTimeFormatter timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getCustomer_Updated_by() {
        return Customer_Updated_by;
    }

    public void setCustomer_Updated_by(String customer_Updated_by) {
        Customer_Updated_by = customer_Updated_by;
    }

    public int getCustomer_Div_ID() {
        return Customer_Div_ID;
    }

    public void setCustomer_Div_ID(int customer_Div_ID) {
        Customer_Div_ID = customer_Div_ID;
    }
}
