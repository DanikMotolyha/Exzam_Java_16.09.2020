import javax.servlet.*;
import java.io.IOException;

public class CheckNumb implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        int number = Integer.getInteger(servletRequest.getParameter("number"));
        if(number < 100){
            servletRequest.setAttribute("info", servletRequest.getContentType());
            servletRequest.setAttribute("number", servletRequest.getContentType());
            servletRequest.getRequestDispatcher("/Two.jsp").forward(servletRequest, servletResponse);
        }else {
            servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest, servletResponse);
        }
    }
}