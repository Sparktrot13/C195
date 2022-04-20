package model;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

public class Users {
    private int User_ID;
    private String User_Name;
    private String User_Password;
    private DateFormat User_Created_Date;
    private String User_Creator;
    private DateTimeFormatter User_TimeStamp;
    private String User_Editor;

    public Users(int user_ID, String user_Name, String user_Password, DateFormat user_Created_Date, String user_Creator, DateTimeFormatter user_TimeStamp, String user_Editor) {
        User_ID = user_ID;
        User_Name = user_Name;
        User_Password = user_Password;
        User_Created_Date = user_Created_Date;
        User_Creator = user_Creator;
        User_TimeStamp = user_TimeStamp;
        User_Editor = user_Editor;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getUser_Name() {
        return User_Name;
    }

    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }

    public String getUser_Password() {
        return User_Password;
    }

    public void setUser_Password(String user_Password) {
        User_Password = user_Password;
    }

    public DateFormat getUser_Created_Date() {
        return User_Created_Date;
    }

    public void setUser_Created_Date(DateFormat user_Created_Date) {
        User_Created_Date = user_Created_Date;
    }

    public String getUser_Creator() {
        return User_Creator;
    }

    public void setUser_Creator(String user_Creator) {
        User_Creator = user_Creator;
    }

    public DateTimeFormatter getUser_TimeStamp() {
        return User_TimeStamp;
    }

    public void setUser_TimeStamp(DateTimeFormatter user_TimeStamp) {
        User_TimeStamp = user_TimeStamp;
    }

    public String getUser_Editor() {
        return User_Editor;
    }

    public void setUser_Editor(String user_Editor) {
        User_Editor = user_Editor;
    }
}
