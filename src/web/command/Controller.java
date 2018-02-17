package web.command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yslabko on 08/13/2017.
 */
public interface Controller {
    String MAIN_PAGE ="/WEB-INF/view/layouts/default.jspx";
    String LOGIN_PAGE="/WEB-INF/view/login.jsp";
    String PRODUCT_PAGE="/WEB-INF/view/products/main.jsp";

    void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException;
}
