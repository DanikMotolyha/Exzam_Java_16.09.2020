import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class CheckNumb implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        int number = Integer.getInteger(servletRequest.getParameter("number"));
        if(number < 100){
            servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
            servletRequest.setAttribute("info", servletRequest.getContentType());
            HttpServletRequest a= (HttpServletRequest)servletRequest;
            servletRequest.setAttribute("number", a.getHeaderNames());
        }
    }
}
