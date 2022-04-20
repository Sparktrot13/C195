package model;

import java.time.format.DateTimeFormatter;

public class Countries {
    private int Country_ID;
    private String Country_Name;
    private DateTimeFormatter Country_Created_Date;
    private String Country_Creator;
    private DateTimeFormatter Country_TimeStamp;
    private String Country_Editor;

    public Countries(int country_ID, String country_Name, DateTimeFormatter country_Created_Date, String country_Creator, DateTimeFormatter country_TimeStamp, String country_Editor) {
        Country_ID = country_ID;
        Country_Name = country_Name;
        Country_Created_Date = country_Created_Date;
        Country_Creator = country_Creator;
        Country_TimeStamp = country_TimeStamp;
        Country_Editor = country_Editor;
    }

    public int getCountry_ID() {
        return Country_ID;
    }

    public void setCountry_ID(int country_ID) {
        Country_ID = country_ID;
    }

    public String getCountry_Name() {
        return Country_Name;
    }

    public void setCountry_Name(String country_Name) {
        Country_Name = country_Name;
    }

    public DateTimeFormatter getCountry_Created_Date() {
        return Country_Created_Date;
    }

    public void setCountry_Created_Date(DateTimeFormatter country_Created_Date) {
        Country_Created_Date = country_Created_Date;
    }

    public String getCountry_Creator() {
        return Country_Creator;
    }

    public void setCountry_Creator(String country_Creator) {
        Country_Creator = country_Creator;
    }

    public DateTimeFormatter getCountry_TimeStamp() {
        return Country_TimeStamp;
    }

    public void setCountry_TimeStamp(DateTimeFormatter country_TimeStamp) {
        Country_TimeStamp = country_TimeStamp;
    }

    public String getCountry_Editor() {
        return Country_Editor;
    }

    public void setCountry_Editor(String country_Editor) {
        Country_Editor = country_Editor;
    }
}
