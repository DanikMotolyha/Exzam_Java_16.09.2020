import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;


@WebServlet("/Reg")
public class servletRegistration  extends HttpServlet {
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
            PreparedStatement statement = connection.prepareStatement("insert into exzam.indexTable values (?,?,?)");
            statement.setString(1,name);
            statement.setString(2,userPassword);
            statement.setInt(3,100);
            statement.executeUpdate();
            //String sql = "insert into exzam.indexTable values (\""+ username +"\",\"" + userPassword + "\"" +",100);";
            connection.close();
        }catch (Exception a){
            a.printStackTrace();
        }


            req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}