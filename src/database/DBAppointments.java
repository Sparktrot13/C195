package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import utility.Utility;
import static model.Lists.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static utility.Utility.*;
import static utility.Utility.confirmation;

public class DBAppointments {
    public static ObservableList<Appointments> getAllAppointments(){
        ObservableList<Appointments> apptList = FXCollections.observableArrayList();
        try {
            String sql = "Select * from appointments";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int appt_ID = rs.getInt("Appointment_ID");
                String title = rs.getString("Title");
                String description = rs.getString("Description");
                String location = rs.getString("Location");
                String type = rs.getString("Type");
                LocalDateTime startTime = rs.getTimestamp("Start").toLocalDateTime();
                LocalDateTime end = rs.getTimestamp("End").toLocalDateTime();
                LocalDateTime created = rs.getTimestamp("Create_Date").toLocalDateTime();
                String creator = rs.getString("Created_By");
                LocalDateTime updated = rs.getTimestamp("Last_Update").toLocalDateTime();
                String updater = rs.getString("Last_Updated_By");
                int cust_ID = rs.getInt("Customer_ID");
                int user_ID = rs.getInt("User_ID");
                int contact_ID = rs.getInt("Contact_ID");
                Appointments a = new Appointments(appt_ID,title,description,location,type,startTime,end,created,creator,updated,updater,cust_ID,user_ID,contact_ID);
                apptList.add(a);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } return apptList;
    }
    public static void insertAppt(String title, String Des, String Loc, String type, Timestamp start, Timestamp end, Timestamp create_Date, String creator, Timestamp lastUpdate, String updatedBy, int cust_ID, int user_ID, int contact_ID){
        try{
            String query1 = "Insert into appointments (Title, Description, Location, Type, Start, End, Create_Date, Created_By, Last_Update, Last_Updated_By, Customer_ID, User_ID, Contact_ID)" +
                    " values (\"" + title + "\", \"" + Des + "\", \"" + Loc + "\", \"" + type + "\", Timestamp(\"" + start + "\"), Timestamp (\"" + end + "\"), Timestamp(\"" + create_Date + "\"), \"" + creator + "\", Timestamp(\"" + lastUpdate + "\"), \"" + updatedBy + "\", " + cust_ID + ", " + user_ID + ", " + contact_ID +")";
            System.out.println(query1);
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query1);
            ps.executeUpdate(query1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteAppt(Appointments a){
        int custID = a.getAppt_Customer_ID();
        String custName = lookupCust(custID);
        LocalDate ld = a.getAppt_StartTime().toLocalDate();
        alert(Utility.alertType.confirmation,deleteAppt + a.getAppointment_ID()+ " for " + custName + " on " + ld + ". " + confirm,confirmation);
        String delete = "Delete from appointments where Appointment_ID = " + a.getAppointment_ID();
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(delete);
            ps.executeUpdate(delete);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void UpdateAppt(int ID,String title, String Des, String Loc, String type, Timestamp start, Timestamp end, Timestamp lastUpdate, String updatedBy, int cust_ID, int user_ID, int contact_ID){
        try{
            String query1 = "Update appointments\n" +
                    "set\n" +
                    "\tTitle = '" + title + "',\n" +
                    "    Description = '" + Des + "',\n" +
                    "    Location = '" + Loc + "',\n" +
                    "    Type = '" + type + "',\n" +
                    "    Start = '" + start + "',\n" +
                    "    End = '" + end + "',\n" +
                    "    Last_Update = '" + lastUpdate + "',\n" +
                    "    Last_Updated_By = '" + updatedBy + "',\n" +
                    "    Customer_ID = '" + cust_ID + "',\n" +
                    "    User_ID = '" + user_ID + "',\n" +
                    "    Contact_ID = '" + contact_ID + "',\n" +
                    "where\n" +
                    "\tAppointment_ID = " + ID;
            System.out.println(query1);
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query1);
            ps.executeUpdate(query1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void insertUser (){
        String ts1 = "2022-04-25 09:55:10";
        String ts2 = "2022-04-25 10:28:28";
        String username = "myUser";
        String password = "Secure";
        Timestamp dateCreated = Timestamp.valueOf(ts1);
        String creator = "Me";
        Timestamp lastUpdated = Timestamp.valueOf(ts2);
        String updater = "also me";

        try{
            String sqlAdd = "Insert into users" + "(User_Name,Password,Create_Date,Created_By,Last_Update,Last_Updated_By)" + " values (\"" + username + "\", \"" + password + "\", timestamp(\"" + dateCreated + "\"), \"" + creator + "\",  timestamp(\"" + lastUpdated + "\"), \"" + updater + "\")";
            System.out.println(sqlAdd);
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sqlAdd);
            ps.executeUpdate(sqlAdd);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
