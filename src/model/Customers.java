package model;

import java.time.format.DateTimeFormatter;

public class Customers {
    private int Customer_ID;
    private String Customer_Name;
    private String Customer_Address;
    private String Customer_Postal;
    private String Customer_Phone;
    private DateTimeFormatter Customer_Created_Date;
    private String Customer_Creator;
    private DateTimeFormatter Customer_TimeStamp;
    private String Customer_Editor;
    private int Customer_Div_ID;

    public Customers(int customer_ID, String customer_Name, String customer_Address, String customer_Postal, String customer_Phone, DateTimeFormatter customer_Created_Date, String customer_Creator, DateTimeFormatter customer_TimeStamp, String customer_Editor, int customer_Div_ID) {
        Customer_ID = customer_ID;
        Customer_Name = customer_Name;
        Customer_Address = customer_Address;
        Customer_Postal = customer_Postal;
        Customer_Phone = customer_Phone;
        Customer_Created_Date = customer_Created_Date;
        Customer_Creator = customer_Creator;
        Customer_TimeStamp = customer_TimeStamp;
        Customer_Editor = customer_Editor;
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

    public DateTimeFormatter getCustomer_Created_Date() {
        return Customer_Created_Date;
    }

    public void setCustomer_Created_Date(DateTimeFormatter customer_Created_Date) {
        Customer_Created_Date = customer_Created_Date;
    }

    public String getCustomer_Creator() {
        return Customer_Creator;
    }

    public void setCustomer_Creator(String customer_Creator) {
        Customer_Creator = customer_Creator;
    }

    public DateTimeFormatter getCustomer_TimeStamp() {
        return Customer_TimeStamp;
    }

    public void setCustomer_TimeStamp(DateTimeFormatter customer_TimeStamp) {
        Customer_TimeStamp = customer_TimeStamp;
    }

    public String getCustomer_Editor() {
        return Customer_Editor;
    }

    public void setCustomer_Editor(String customer_Editor) {
        Customer_Editor = customer_Editor;
    }

    public int getCustomer_Div_ID() {
        return Customer_Div_ID;
    }

    public void setCustomer_Div_ID(int customer_Div_ID) {
        Customer_Div_ID = customer_Div_ID;
    }
}
