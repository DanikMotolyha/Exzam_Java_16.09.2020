import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class ButtonTag extends TagSupport {


    private String name;
    private String value;

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().print("<input type = submit name="+name+">");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }
}
