import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;

@WebServlet("/main")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Registr.jsp");
        requestDispatcher.forward(req, resp);    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String id = req.getParameter("id");
        String subject = req.getParameter("subject");
        String mark = req.getParameter("mark");

        User user = new User(name, surname, id, subject, mark);

        try(FileWriter writer = new FileWriter("D:\\2k2s\\Сессия\\джава\\exam\\user.txt", true))
        {
            String text = name + " " + surname + " " + id + " " + subject +" "+ mark + "\n";
            writer.write(text);


            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

doGet(req,resp);
    }
}
