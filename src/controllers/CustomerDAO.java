package controllers;

import java.util.*;
import java.sql.*;

import models.FoodProduct;
import utils.Database;
import models.Customer;
import models.Address;

public class CustomerDAO {
    public static ArrayList<Customer> findAllCustomers(){
        ArrayList<Customer> customerArray = new ArrayList<>();
        try{
            Connection con = new Database().getConnection();
            if(con == null){
                return customerArray;
            }
            PreparedStatement statement = con.prepareStatement("SELECT * FROM customer");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                customerArray.add(setUpCustomerFromQuery(result));
            }
            return customerArray;
        }catch(SQLException e){
            e.printStackTrace();
        }
        return customerArray;
    }
    public static Customer findCustomer(int id){
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = null;
        try {
            Connection connection = new Database().getConnection();
            if (connection != null) {
                String sqlQuery = "SELECT * FROM customer WHERE id = ?";
                PreparedStatement readyStatement = connection.prepareStatement(sqlQuery);
                readyStatement.setInt(1, id);
                ResultSet result = readyStatement.executeQuery();
                while (result.next()) {
                    customers.add(setUpCustomerFromQuery(result));
                }
                result.close();
                readyStatement.close();
                connection.close();
                if(customers.size() > 0){
                    customer = customers.get(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
    public static boolean deleteCustomer(int id){
        try {
            if(findCustomer(id) == null){
                return false;
            }
            Connection connection = new Database().getConnection();
            if (connection != null) {
                String sqlQuery = "DELETE FROM customer WHERE id = ?";
                PreparedStatement readyStatement = connection.prepareStatement(sqlQuery);
                readyStatement.setInt(1, id);
                readyStatement.executeUpdate();
                readyStatement.close();
                connection.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateCustomer(Customer customer){
        try {
            if(findCustomer(customer.getCustomerID()) == null){
                return false;
            }
            Connection connection = new Database().getConnection();
            if (connection != null) {
                String sqlQuery = "UPDATE customer SET name = ?, address1 = ?,address2 = ?, address3 = ?, country = ?, postCode = ?, phone = ?  WHERE id = ?";
                PreparedStatement readyStatement = connection.prepareStatement(sqlQuery);
                readyStatement.setString(1, customer.getCustomerName());
                readyStatement.setString(2, customer.getAddress().getAddressLine1());
                readyStatement.setString(3, customer.getAddress().getAddressLine2());
                readyStatement.setString(4, customer.getAddress().getAddressLine3());
                readyStatement.setString(5, customer.getAddress().getCountry());
                readyStatement.setString(6, customer.getAddress().getPostCode());
                readyStatement.setString(7, customer.getTelephoneNumber());
                readyStatement.setInt(8, customer.getCustomerID());
                readyStatement.executeUpdate();
                readyStatement.close();
                connection.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean addCustomer(Customer customer){
        try {
            Connection connection = new Database().getConnection();
            if (connection != null) {
                String sqlQuery = "INSERT INTO customer (name,address1,address2,address3,country,postCode,phone) VALUES (?,?,?,?,?,?,?)";
                PreparedStatement readyStatement = connection.prepareStatement(sqlQuery);
                readyStatement.setString(1, customer.getCustomerName());
                readyStatement.setString(2, customer.getAddress().getAddressLine1());
                readyStatement.setString(3, customer.getAddress().getAddressLine2());
                readyStatement.setString(4, customer.getAddress().getAddressLine3());
                readyStatement.setString(5, customer.getAddress().getCountry());
                readyStatement.setString(6, customer.getAddress().getPostCode());
                readyStatement.setString(7, customer.getTelephoneNumber());
                readyStatement.executeUpdate();
                readyStatement.close();
                connection.close();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    private static Customer setUpCustomerFromQuery(ResultSet result) throws SQLException{
        Address address = new Address(result.getString("address1"),result.getString("address2"),
                result.getString("address3"),result.getString("country"),
                result.getString("postCode"));
        return new Customer(result.getInt("id"),result.getString("name"),
                address,result.getString("phone"));
    }
}
