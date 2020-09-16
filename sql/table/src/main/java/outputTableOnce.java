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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet2")
public class outputTableOnce extends HttpServlet {
    static class index{
        public static Integer index = 0;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        Connection connection = null;
        String url = "jdbc:mysql://localhost/exzam?serverTimezone=Europe/Moscow&useSSL=FALSE";
        String username = "root";
        String password = "Danik77995588";
        Cookie[] cookie = req.getCookies();
        Integer number = 0;
        for (Cookie a: cookie) {
            if(a.getName().equals("Index")){
                number = Integer.parseInt(a.getValue());
            }
        }
        if(number == 0) {
            Cookie cookie1 = new Cookie("Index", "1");
            resp.addCookie(cookie1);
            number = 1;
        }
        try {
            connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            //ResultSet resultSet = statement.executeQuery("SELECT * FROM exzam.exztable where Id =" + ++index.index);
            ResultSet resultSet = statement.executeQuery("SELECT * FROM exzam.exztable where Id =" + number++);
            resp.addCookie(new Cookie("Test", index.index.toString()));
            while (resultSet.next()) {
                req.setAttribute("mail", resultSet.getString(1));
                req.setAttribute("phone", resultSet.getString(2));
            }
            resultSet.close();
            connection.close();
            resp.addCookie(new Cookie("Index",number.toString()));
        }catch (Exception a){
            a.printStackTrace();
        }
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addCookie(new Cookie("Index", "1"));
        Cookie[] cookie = req.getCookies();
        for (Cookie cook: cookie) {
            cook.setMaxAge(0);
        }
        index.index = 0;
        req.setAttribute("mail","testing!!!");
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
