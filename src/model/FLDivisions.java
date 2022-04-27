package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FLDivisions {
    private int Div_ID;
    private String Division_Name;
    private LocalDateTime Div_Created_Date;
    private String Div_Creator;
    private LocalDateTime Div_TimeStamp;
    private String Div_TimeStamp_User;
    private int Div_Country_ID;

    public FLDivisions(int div_ID, String division_Name, LocalDateTime div_Created_Date, String div_Creator, LocalDateTime div_TimeStamp, String div_TimeStamp_User, int div_Country_ID) {
        Div_ID = div_ID;
        Division_Name = division_Name;
        Div_Created_Date = div_Created_Date;
        Div_Creator = div_Creator;
        Div_TimeStamp = div_TimeStamp;
        Div_TimeStamp_User = div_TimeStamp_User;
        Div_Country_ID = div_Country_ID;
    }

    public int getDiv_ID() {
        return Div_ID;
    }

    public void setDiv_ID(int div_ID) {
        Div_ID = div_ID;
    }

    public String getDivision_Name() {
        return Division_Name;
    }

    public void setDivision_Name(String division_Name) {
        Division_Name = division_Name;
    }

    public LocalDateTime getDiv_Created_Date() {
        return Div_Created_Date;
    }

    public void setDiv_Created_Date(LocalDateTime div_Created_Date) {
        Div_Created_Date = div_Created_Date;
    }

    public String getDiv_Creator() {
        return Div_Creator;
    }

    public void setDiv_Creator(String div_Creator) {
        Div_Creator = div_Creator;
    }

    public LocalDateTime getDiv_TimeStamp() {
        return Div_TimeStamp;
    }

    public void setDiv_TimeStamp(LocalDateTime div_TimeStamp) {
        Div_TimeStamp = div_TimeStamp;
    }

    public String getDiv_TimeStamp_User() {
        return Div_TimeStamp_User;
    }

    public void setDiv_TimeStamp_User(String div_TimeStamp_User) {
        Div_TimeStamp_User = div_TimeStamp_User;
    }

    public int getDiv_Country_ID() {
        return Div_Country_ID;
    }

    public void setDiv_Country_ID(int div_Country_ID) {
        Div_Country_ID = div_Country_ID;
    }
}
