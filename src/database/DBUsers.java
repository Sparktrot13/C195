package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import model.Users;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import static controller.LoginController.*;
import static Utility.Utility.*;

public class DBUsers {
    public static ObservableList<Users> getAllUsers() {
        ObservableList<Users> UsersList = FXCollections.observableArrayList();
        try {
            String sql = "Select * from users";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int User_ID = rs.getInt("User_ID");
                String User_Name = rs.getString("User_Name");
                String User_Password = rs.getString("Password");
                Timestamp User_Created_Date = rs.getTimestamp("Create_Date");
                String User_Creator = rs.getString("Created_By");
                Timestamp User_TimeStamp = rs.getTimestamp("Last_Update");
                String User_Editor = rs.getString("Last_Updated_By");
                Users u = new Users(User_ID,User_Name,User_Password,User_Created_Date,User_Creator, User_TimeStamp,User_Editor);
                UsersList.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return UsersList;
    }
    public static Boolean chkCredentials (TextField username, TextField password) throws SQLException {
        String user = username.getText();
        String pass = password.getText();
        String chk = "Select User_Name, Password from users where User_Name = \"" + user + "\" and Password = \"" + pass + "\"";
        System.out.println(chk);
        PreparedStatement ps = DBConnection.getConnection().prepareStatement(chk);
        ResultSet rs = ps.executeQuery();
        String DBUser = null;
        String DBPass = null;
        while (rs.next()) {
            DBUser = rs.getString("User_Name");
            DBPass = rs.getString("Password");
        }
        if (user.equals(DBUser) && (pass.equals(DBPass))){
            return true;
        } else return false;
    }
}