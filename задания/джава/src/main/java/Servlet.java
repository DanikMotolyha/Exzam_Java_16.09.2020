import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/main")
public class Servlet extends HttpServlet {
    int countofans = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String s = req.getParameter("summer");
        String m = req.getParameter("morning");
        if (s.equals("yes")){
           int k = new Date().getMonth();
           if(k>4 && k<8){
               countofans+=5;
           }

        }
        if (m.equals("yes")){
            int k = new Date().getHours();
            if(k>3 && k<11){
                countofans+=5;
            }

        }
        req.setAttribute("count", countofans);
        req.getRequestDispatcher("/index.jsp").forward(req,resp);
    }
}
