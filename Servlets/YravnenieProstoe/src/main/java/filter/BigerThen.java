package filter;

import javax.servlet.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class BigerThen implements Filter {
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
        int i = new Integer(servletRequest.getParameter("number"));
        if(i > 10){
            LOGGER.info(servletRequest.getParameter("number") + " " + LocalDateTime.now());
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            servletRequest.getRequestDispatcher("/index.jsp").forward(servletRequest,servletResponse);
        }
    }
}

