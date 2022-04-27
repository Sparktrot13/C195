package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customers;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static utility.Utility.*;

public class DBCustomers {
    public static ObservableList<Customers> getAllCustomers(){
        ObservableList<Customers> Cust_List = FXCollections.observableArrayList();
        try{
            String sql = "Select * from customers";
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int ID = rs.getInt("Customer_ID");
                String Name = rs.getString("Customer_Name");
                String Address = rs.getString("Address");
                String Phone = rs.getString("Phone");
                String Postal = rs.getString("Postal_Code");
                Date Created= rs.getDate("Create_Date");
                String Creator = rs.getString("Created_By");
                Date TimeStamp = rs.getDate("Last_Update");
                String Editor = rs.getString("Last_Updated_By");
                int Div_ID = rs.getInt("Division_ID");
                Customers c = new Customers(ID,Name,Address,Postal,Phone,Created,Creator,TimeStamp,Editor,Div_ID);
                Cust_List.add(c);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } return Cust_List;
    }
    public static void deleteCustomer(Customers c){
        alert(alertType.confirmation,deleteCustomer + c.getCustomer_Name() + "'s record. " + confirm,confirmation);
    }
}
