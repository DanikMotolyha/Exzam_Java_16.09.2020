import com.sun.deploy.net.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class filterToFile implements Filter {

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
        else{
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

}