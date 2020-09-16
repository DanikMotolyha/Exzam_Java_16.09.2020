import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Connection connection = null;

            String url = "jdbc:mysql://localhost/exzam?serverTimezone=Europe/Moscow&useSSL=FALSE";
            String username = "root";
            String password = "Danik77995588";
            Class.forName ("com.mysql.cj.jdbc.Driver");
            DriverManager.setLogStream(System.out);
            /*
            String sqlCommand1 = "CREATE TABLE tesTable (Name VARCHAR(20), Price INT, Id INT PRIMARY KEY AUTO_INCREMENT)";
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                System.out.println("Success!");
                conn.setAutoCommit(false);
                Statement statement = conn.createStatement();
                //statement.executeUpdate(sqlCommand1);
            }
            */
            connection = DriverManager.getConnection(url, username,password);

            Statement statement = null;
            statement = connection.createStatement();

            String query = "SELECT * FROM exzam.testable";
            ResultSet resultSet = statement.executeQuery(query);
            System.out.println("21312");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + " " + resultSet.getInt(2));
            }
    }
}