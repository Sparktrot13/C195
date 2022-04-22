package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Countries;

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

            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
