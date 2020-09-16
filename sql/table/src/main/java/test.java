import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String url = "jdbc:mysql://localhost/exzam?serverTimezone=Europe/Moscow&useSSL=FALSE";
        String username = "root";
        String password = "Danik77995588";
        Connection connection = DriverManager.getConnection(url, username, password);
        List<Product> items = new ArrayList<Product>();
        connection = DriverManager.getConnection(url, username, password);
        Statement statement =  connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM exzam.testable");
        while (resultSet.next()) {
            items.add(new Product(resultSet.getString(1), resultSet.getInt(2)));
        }
        for (Product a: items) {
            System.out.println(a);
        }
    }
}
