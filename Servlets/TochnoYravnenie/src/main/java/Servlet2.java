import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Double y;
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        String c = request.getParameter("c");
        String x = request.getParameter("x");
        if(a.equals("")||b.equals("")||c.equals("")||x.equals("")) {
            request.getRequestDispatcher("/Ask1.jsp").forward(request, response);
        }
        else {
        y=Double.parseDouble(a)+Double.parseDouble(b)*Double.parseDouble(x)+Double.parseDouble(c)*Double.parseDouble(x)*Double.parseDouble(x);
        request.setAttribute("y", y);
        request.getRequestDispatcher("/Result.jsp").forward(request, response);
        }

    }
}
