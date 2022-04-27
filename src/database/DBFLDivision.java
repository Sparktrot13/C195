package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Contacts;
import model.FLDivisions;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class DBFLDivision {
    public static ObservableList<FLDivisions> getAllFLDivision(){
        ObservableList<FLDivisions> list = FXCollections.observableArrayList();
        try {
            String sql = "Select * from first_level_divisions";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("Division_ID");
                String name = rs.getString("Division");
                LocalDateTime created = rs.getTimestamp("Create_Date").toLocalDateTime();
                String creator = rs.getString("Created_By");
                LocalDateTime updated = rs.getTimestamp("Last_Update").toLocalDateTime();
                String updater = rs.getString("Last_Updated_By");
                int country = rs.getInt("Country_ID");
                FLDivisions f = new FLDivisions(ID,name, created,creator,updated,updater,country);
                list.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
