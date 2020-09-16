import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        boolean check = false;
        Cookie[] cookie = req.getCookies();
        for (Cookie c: cookie) {
            if(c.getName().equals(login)&&c.getValue().equals(pass))
                check = true;
        }
        if(check)
            req.getRequestDispatcher("/Hello.jsp").forward(req, resp);
        else {
            Cookie ck = new Cookie(login,pass);
            resp.addCookie(ck);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}