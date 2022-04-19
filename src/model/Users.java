package model;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;

public class Users {
    private int User_ID;
    private String User_Name;
    private String Password;
    private DateFormat Create_Date;
    private String Created_by;
    private DateTimeFormatter Last_Updated;
    private String Last_Updated_By;

    public Users(int user_ID, String user_Name, String password, DateFormat create_Date, String created_by, DateTimeFormatter last_Updated, String last_Updated_By) {
        User_ID = user_ID;
        User_Name = user_Name;
        Password = password;
        Create_Date = create_Date;
        Created_by = created_by;
        Last_Updated = last_Updated;
        Last_Updated_By = last_Updated_By;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public DateFormat getCreate_Date() {
        return Create_Date;
    }

    public void setCreate_Date(DateFormat create_Date) {
        Create_Date = create_Date;
    }

    public String getCreated_by() {
        return Created_by;
    }

    public void setCreated_by(String created_by) {
        Created_by = created_by;
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
}
