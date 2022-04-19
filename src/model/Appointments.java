package model;

import java.time.format.DateTimeFormatter;

public class Appointments {
    private int Appointment_ID;
    private String Title;
    private String Description;
    private String Location;
    private String Type;
    private DateTimeFormatter StartTime;
    private DateTimeFormatter EndTime;
    private DateTimeFormatter Created_Date;
    private String Created_By;
    private DateTimeFormatter Last_Updated;
    private String Last_Updated_By;
    private int Customer_ID;
    private int User_ID;
    private int Contact_ID;

    public Appointments(int appointment_ID, String title, String description, String location, String type, DateTimeFormatter startTime, DateTimeFormatter endTime, DateTimeFormatter created_Date, String created_By, DateTimeFormatter last_Updated, String last_Updated_By, int customer_ID, int user_ID, int contact_ID) {
        Appointment_ID = appointment_ID;
        Title = title;
        Description = description;
        Location = location;
        Type = type;
        StartTime = startTime;
        EndTime = endTime;
        Created_Date = created_Date;
        Created_By = created_By;
        Last_Updated = last_Updated;
        Last_Updated_By = last_Updated_By;
        Customer_ID = customer_ID;
        User_ID = user_ID;
        Contact_ID = contact_ID;
    }

    public int getAppointment_ID() {
        return Appointment_ID;
    }

    public void setAppointment_ID(int appointment_ID) {
        Appointment_ID = appointment_ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public DateTimeFormatter getStartTime() {
        return StartTime;
    }

    public void setStartTime(DateTimeFormatter startTime) {
        StartTime = startTime;
    }

    public DateTimeFormatter getEndTime() {
        return EndTime;
    }

    public void setEndTime(DateTimeFormatter endTime) {
        EndTime = endTime;
    }

    public DateTimeFormatter getCreated_Date() {
        return Created_Date;
    }

    public void setCreated_Date(DateTimeFormatter created_Date) {
        Created_Date = created_Date;
    }

    public String getCreated_By() {
        return Created_By;
    }

    public void setCreated_By(String created_By) {
        Created_By = created_By;
    }

    public DateTimeFormatter getLast_Updated() {
        return Last_Updated;
    }

    public void setLast_Updated(DateTimeFormatter last_Updated) {
        Last_Updated = last_Updated;
    }

    public String getLast_Updated_By() {
        return Last_Updated_By;
    }

    public void setLast_Updated_By(String last_Updated_By) {
        Last_Updated_By = last_Updated_By;
    }

    public int getCustomer_ID() {
        return Customer_ID;
    }

    public void setCustomer_ID(int customer_ID) {
        Customer_ID = customer_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public int getContact_ID() {
        return Contact_ID;
    }

    public void setContact_ID(int contact_ID) {
        Contact_ID = contact_ID;
    }
}
