import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import org.json.JSONObject;
import org.json.JSONWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        FileWriter write = new FileWriter("d:\\text.json", true);
        String name = req.getParameter("userName");
        String password = req.getParameter("userPass");
        JSONObject a = new JSONObject();
        a.put("userName", name);
        a.put("userPass", password);
        write.write(a.toString() + "\n");
        //write.write(name + " " + password +"\n");
        write.flush();
        write.close();
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
class UserName{
    public String name;
    public String password;
    public UserName(String name,String password){
        this.name = name;
        this.password = password;
    }
}
/* post method
Object obj = parser.parse(new FileReader("f:\\test.json"));

            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            String name = (String) jsonObject.get("name");
            System.out.println(name);

            long age = (Long) jsonObject.get("age");
            System.out.println(age);

           //loop array
            JSONArray msg = (JSONArray) jsonObject.get("messages");
            Iterator<String> iterator = msg.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
* */
