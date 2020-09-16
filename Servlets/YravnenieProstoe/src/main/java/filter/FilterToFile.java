package filter;

import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class FilterToFile implements Filter {



    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        int i = new Integer(servletRequest.getParameter("number"));
        if(i < 100){
            HttpServletRequest a = (HttpServletRequest)servletRequest;
            servletRequest.setAttribute("info", a.getHeaderNames());
            servletRequest.setAttribute("number", i);
            servletRequest.getRequestDispatcher("/input.jsp").forward(servletRequest,servletResponse);
        }
        else{
            servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest,servletResponse);
        }
    }
}
