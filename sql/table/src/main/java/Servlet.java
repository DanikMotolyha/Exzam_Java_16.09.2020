import org.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Connection connection = null;
        List<Product> items = new ArrayList<Product>();
        String url = "jdbc:mysql://localhost/exzam?serverTimezone=Europe/Moscow&useSSL=FALSE";
        String username = "root";
        String password = "Danik77995588";
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM exzam.testable");
            while (resultSet.next()) {
                Product a = new Product();
                a.setName(resultSet.getString(1));
                a.setPrice(resultSet.getInt(2));
                items.add(a);
            }
            req.setAttribute("products", items);
            resultSet.close();
            connection.close();
            for (Product a : items) {
                System.out.println(a);
            }
        }catch (Exception a){

        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}

