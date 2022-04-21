package model;

import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Appointments {
    private int Appointment_ID;
    private String Appt_Title;
    private String Appt_Description;
    private String Appt_Location;
    private String Appt_Type;
    private Date Appt_StartTime;
    private Date Appt_EndTime;
    private Date Appt_Created_Date;
    private String Appt_Creator;
    private Date Appt_TimeStamp;
    private String Appt_Editor;
    private int Appt_Customer_ID;
    private int Appt_User_ID;
    private int Appt_Contact_ID;

    public Appointments(int appointment_ID, String appt_Title, String appt_Description, String appt_Location, String appt_Type, Date appt_StartTime, Date appt_EndTime, Date appt_Created_Date, String appt_Creator, Date appt_TimeStamp, String appt_Editor, int appt_Customer_ID, int appt_User_ID, int appt_Contact_ID) {
        Appointment_ID = appointment_ID;
        Appt_Title = appt_Title;
        Appt_Description = appt_Description;
        Appt_Location = appt_Location;
        Appt_Type = appt_Type;
        Appt_StartTime = appt_StartTime;
        Appt_EndTime = appt_EndTime;
        Appt_Created_Date = appt_Created_Date;
        Appt_Creator = appt_Creator;
        Appt_TimeStamp = appt_TimeStamp;
        Appt_Editor = appt_Editor;
        Appt_Customer_ID = appt_Customer_ID;
        Appt_User_ID = appt_User_ID;
        Appt_Contact_ID = appt_Contact_ID;
    }

    public int getAppointment_ID() {
        return Appointment_ID;
    }

    public void setAppointment_ID(int appointment_ID) {
        Appointment_ID = appointment_ID;
    }

    public String getAppt_Title() {
        return Appt_Title;
    }

    public void setAppt_Title(String appt_Title) {
        Appt_Title = appt_Title;
    }

    public String getAppt_Description() {
        return Appt_Description;
    }

    public void setAppt_Description(String appt_Description) {
        Appt_Description = appt_Description;
    }

    public String getAppt_Location() {
        return Appt_Location;
    }

    public void setAppt_Location(String appt_Location) {
        Appt_Location = appt_Location;
    }

    public String getAppt_Type() {
        return Appt_Type;
    }

    public void setAppt_Type(String appt_Type) {
        Appt_Type = appt_Type;
    }

    public Date getAppt_StartTime() {
        return Appt_StartTime;
    }

    public void setAppt_StartTime(Date appt_StartTime) {
        Appt_StartTime = appt_StartTime;
    }

    public Date getAppt_EndTime() {
        return Appt_EndTime;
    }

    public void setAppt_EndTime(Date appt_EndTime) {
        Appt_EndTime = appt_EndTime;
    }

    public Date getAppt_Created_Date() {
        return Appt_Created_Date;
    }

    public void setAppt_Created_Date(Date appt_Created_Date) {
        Appt_Created_Date = appt_Created_Date;
    }

    public String getAppt_Creator() {
        return Appt_Creator;
    }

    public void setAppt_Creator(String appt_Creator) {
        Appt_Creator = appt_Creator;
    }

    public Date getAppt_TimeStamp() {
        return Appt_TimeStamp;
    }

    public void setAppt_TimeStamp(Date appt_TimeStamp) {
        Appt_TimeStamp = appt_TimeStamp;
    }

    public String getAppt_Editor() {
        return Appt_Editor;
    }

    public void setAppt_Editor(String appt_Editor) {
        Appt_Editor = appt_Editor;
    }

    public int getAppt_Customer_ID() {
        return Appt_Customer_ID;
    }

    public void setAppt_Customer_ID(int appt_Customer_ID) {
        Appt_Customer_ID = appt_Customer_ID;
    }

    public int getAppt_User_ID() {
        return Appt_User_ID;
    }

    public void setAppt_User_ID(int appt_User_ID) {
        Appt_User_ID = appt_User_ID;
    }

    public int getAppt_Contact_ID() {
        return Appt_Contact_ID;
    }

    public void setAppt_Contact_ID(int appt_Contact_ID) {
        Appt_Contact_ID = appt_Contact_ID;
    }
}
