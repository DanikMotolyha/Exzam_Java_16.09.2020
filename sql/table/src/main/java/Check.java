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

@WebServlet("/Check")
public class  Check  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection connection = null;
        String url = "jdbc:mysql://localhost/exzam?serverTimezone=Europe/Moscow&useSSL=FALSE";
        String username = "root";
        String password = "Danik77995588";
        String index = req.getParameter("index");
        String userName = "";
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            Cookie[] cookies = req.getCookies();
            for (Cookie a: cookies) {
                if(a.getName().equals("Username")){
                    userName = a.getValue();
                }
            }
            String sql = "UPDATE exzam.indexTable SET indexUser=" + index + " WHERE userName = \""+userName + "\"";
            if(statement.executeUpdate(sql) != 0){
                req.setAttribute("indexUser", "new cout " + index);
            }else
                req.setAttribute("indexUser","error");
            req.getRequestDispatcher("/changeInt.jsp").forward(req, resp);
            connection.close();
        }catch (Exception a){
            a.printStackTrace();
        }
    }
}