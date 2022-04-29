package database;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Customers;
import java.sql.*;

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
    public static void updateCustomer(String name, String address, String phone, String postal, Timestamp lastUpdate, String updatedBy, int ID){
        try{
            String query1 = "Update customers\n" +
                    "set\n" +
                    "\tCustomer_Name = '" + name + "',\n" +
                    "    Address = '" + address + "',\n" +
                    "    Phone = '" + phone + "',\n" +
                    "    Postal_Code = '" + postal + "',\n" +
                    "    Last_Update = '" + lastUpdate + "',\n" +
                    "    Last_Updated_By = '" + updatedBy + "'\n" +
                    "where\n" +
                    "\tAppointment_ID = " + ID;
            System.out.println(query1);
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query1);
            ps.executeUpdate(query1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void insertCustomer(String name, String address, String postal, String phone, Timestamp created, String creator, Timestamp lastUpdate, String updatedBy, int divID){
        try{
            String query1 = "Insert into customers(\n" +
                    "Customer_Name,\n" +
                    "Address,\n" +
                    "Postal_Code,\n" +
                    "Phone,\n" +
                    "Create_Date,\n" +
                    "Created_By,\n" +
                    "Last_Update,\n" +
                    "Last_Updated_By,\n" +
                    "Division_ID\n" +
                    ") values (\n" +
                    "'" + name + "',\n" +
                    "'" + address + "',\n" +
                    "'" + postal + "',\n" +
                    "'" + phone + "',\n" +
                    "'" + created + "',\n" +
                    "'" + creator + "',\n" +
                    "'" + lastUpdate + "',\n" +
                    "'" + updatedBy + "',\n" +
                    "'" + divID + "')";
            System.out.println(query1);
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(query1);
            ps.executeUpdate(query1);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void deleteCustomer(Customers c){
        alert(alertType.confirmation,deleteCustomer + c.getCustomer_Name() + "'s record. " + confirm,confirmation);
        String delete = "Delete from customers where Customer_ID = " + c.getCustomer_ID();
        try{
            PreparedStatement ps = DBConnection.getConnection().prepareStatement(delete);
            ps.executeUpdate(delete);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
