import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
@WebServlet("/servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println();
        HttpSession session = req.getSession();
        if ((session.getAttribute("name")) == null) {
            session.setAttribute("name", 1);
        } else {
            System.out.println((int) session.getAttribute("name"));
        }
        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("cookie")) {
                System.out.println(cookie.getValue());
            }

        }

        Cookie cookie = new Cookie("cookie", "cookie1");
        cookie.setMaxAge(24 * 60 * 60);
        resp.addCookie(cookie);

    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
