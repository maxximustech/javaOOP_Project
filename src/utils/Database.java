package utils;
import java.util.*;
import java.sql.*;



public class Database {
    private Connection connection = null;
    public Database() throws SQLException{
        this.connection = DriverManager.getConnection(Constants.dbUrl);
    }
    public Connection getConnection(){
        return connection;
    }
}
