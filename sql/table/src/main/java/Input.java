import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/Input")
public class  Input  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        String url = "jdbc:mysql://localhost/exzam?serverTimezone=Europe/Moscow&useSSL=FALSE";
        String username = "root";
        String password = "Danik77995588";
        String name = req.getParameter("user");
        String userPassword = req.getParameter("password");
        if(name.equals("")||userPassword.equals(""))
            req.getRequestDispatcher("/ErrorMessage.jsp").forward(req, resp);

        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM exzam.indexTable"+
                            " where userName= \""+ name +
                            "\" and userPassword=\"" + userPassword + "\";";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                resp.addCookie(new Cookie("Username", name));
                connection.close();
                req.getRequestDispatcher("/changeInt.jsp").forward(req, resp);
            }
            connection.close();
            req.getRequestDispatcher("/Registration.jsp").forward(req, resp);
        }catch (Exception a){
            a.printStackTrace();
        }
    }
}