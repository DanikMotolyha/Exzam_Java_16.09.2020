import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(String.valueOf(javax.servlet.Servlet.class));

    public static FileHandler fh;
    static {
        try {
            fh = new FileHandler("D:/EXZAM.log");
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.addHandler(fh);
        fh.setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getMessage() + "\n";
            }
        });
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        String a = request.getParameter("user");
        if(a.equals("Admin") == true||a.equals("User") == true){
            HttpSession session = request.getSession();
            String message = "Role - " + a +
                    "\n Session id -" + session.getId() +
                    "\n Session create -" + session.getCreationTime() +
                    "\n Time - " + LocalDateTime.now() +
                    "\n url - " + request.getRequestURI();
            request.setAttribute("message", message);
            LOGGER.info(message);
            if(a.equals("Admin")) request.getSession().setMaxInactiveInterval(60);
            else request.getSession().setMaxInactiveInterval(20);
            request.getRequestDispatcher("/Result.jsp").forward(request, response);
        }
        else{
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

}