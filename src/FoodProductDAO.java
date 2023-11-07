import java.sql.*;
import java.util.ArrayList;

public class FoodProductDAO {
    private static final String sqliteURL = "jdbc:sqlite:C:/Users/Maxximus/javaProjects/oopProject/oopfood.sqlite";
    private static Connection createConnection() {
        Connection sqlConn = null;
        try {
            sqlConn = DriverManager.getConnection(sqliteURL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sqlConn;
    }
    public static ArrayList<FoodProduct> findAllProducts(){
        ArrayList<FoodProduct> products = new ArrayList<>();
        try {
            Connection connection = createConnection();
            if (connection != null) {
                String sqlQuery = "SELECT * FROM foodProduct";
                PreparedStatement readyStatement = connection.prepareStatement(sqlQuery);
                ResultSet queryResult = readyStatement.executeQuery();
                while (queryResult.next()) {
                    int id = queryResult.getInt("id");
                    String sku = queryResult.getString("sku");
                    String desc = queryResult.getString("description");
                    String category = queryResult.getString("category");
                    int price = queryResult.getInt("price");
                    products.add(new FoodProduct(id,sku,desc,category,price));
                }
                queryResult.close();
                readyStatement.close();
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
    public static FoodProduct findProduct(int id){
        ArrayList<FoodProduct> products = new ArrayList<>();
        FoodProduct product = null;
        try {
            Connection connection = createConnection();
            if (connection != null) {
                String sqlQuery = "SELECT * FROM foodProduct WHERE id = ?";
                PreparedStatement readyStatement = connection.prepareStatement(sqlQuery);
                readyStatement.setInt(1, id);
                ResultSet queryResult = readyStatement.executeQuery();
                while (queryResult.next()) {
                    String sku = queryResult.getString("sku");
                    String desc = queryResult.getString("description");
                    String category = queryResult.getString("category");
                    int price = queryResult.getInt("price");
                    products.add(new FoodProduct(id,sku,desc,category,price));
                }
                queryResult.close();
                readyStatement.close();
                connection.close();
                if(products.size() > 0){
                    product = products.get(0);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
    public static boolean deleteProduct(int id){
        try {
            if(findProduct(id) == null){
                return false;
            }
            Connection connection = createConnection();
            if (connection != null) {
                String sqlQuery = "DELETE FROM foodProduct WHERE id = ?";
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
    public static boolean updateProduct(FoodProduct product){
        try {
            if(findProduct(product.getID()) == null){
                return false;
            }
            Connection connection = createConnection();
            if (connection != null) {
                String sqlQuery = "UPDATE foodProduct SET sku = ?, description = ?,category = ?, price = ?  WHERE id = ?";
                PreparedStatement readyStatement = connection.prepareStatement(sqlQuery);
                readyStatement.setString(1, product.getSKU());
                readyStatement.setString(2, product.getDescription());
                readyStatement.setString(3, product.getCategory());
                readyStatement.setInt(4, product.getPrice());
                readyStatement.setInt(5, product.getID());
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
    public static boolean addProduct(FoodProduct product){
        try {
            Connection connection = createConnection();
            if (connection != null) {
                String sqlQuery = "INSERT INTO foodProduct (sku,description,category,price) VALUES (?,?,?,?)";
                PreparedStatement readyStatement = connection.prepareStatement(sqlQuery);
                readyStatement.setString(1, product.getSKU());
                readyStatement.setString(2, product.getDescription());
                readyStatement.setString(3, product.getCategory());
                readyStatement.setInt(4, product.getPrice());
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
}
