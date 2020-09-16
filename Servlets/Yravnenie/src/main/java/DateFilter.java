
import javax.servlet.*;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.*;

public class DateFilter implements Filter {

    private static final Logger LOGGER = Logger.getLogger(String.valueOf(Servlet.class));

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

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        int number = Integer.getInteger(servletRequest.getParameter("number"));
        if(number > 10){
            LOGGER.info(servletRequest.getParameter("number") + LocalDateTime.now());
        }
        servletRequest.getRequestDispatcher("/Weekends.jsp").forward(servletRequest, servletResponse);
        servletRequest.setAttribute("info", servletRequest.getContentType());
        servletRequest.setAttribute("number", servletRequest.getContentType());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
