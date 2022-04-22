package database;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Appointments;
import static database.DBConnection.*;

import java.sql.*;

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
                Date start = rs.getDate("Start");
                Date end = rs.getDate("End");
                Date created = rs.getDate("Create_Date");
                String creator = rs.getString("Created_By");
                Date updated = rs.getDate("Last_Update");
                String updater = rs.getString("Last_Updated_By");
                int cust_ID = rs.getInt("Customer_ID");
                int user_ID = rs.getInt("User_ID");
                int contact_ID = rs.getInt("Contact_ID");
                Appointments a = new Appointments(appt_ID,title,description,location,type,start,end,created,creator,updated,updater,cust_ID,user_ID,contact_ID);
                apptList.add(a);
            }
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } return apptList;
    }
}
