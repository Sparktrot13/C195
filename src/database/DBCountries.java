package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCountries {
    public static ObservableList<Countries> getAllCountries(){
        ObservableList<Countries> CountriesList = FXCollections.observableArrayList();
        try{
            String sql = "Select * from countries";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int ID = rs.getInt("Country_ID");
                String Name = rs.getString("Country");
                Date Created = rs.getDate("Create_Date");
                String Creator = rs.getString("Created_By");
                Date TimeStamp = rs.getDate("Last_Update");
                String Editor = rs.getString("Last_Updated_By");
                Countries c = new Countries(ID, Name, Created,Creator, TimeStamp,Editor);
                CountriesList.add(c);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } return CountriesList;
    }
}
