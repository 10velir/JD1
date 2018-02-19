package web.command.impl;

import services.ProductService;
import services.impl.ProductServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yslabko on 08/13/2017.
 */
public class SignupController implements Controller {
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+ "/frontController?command=createOrder");*/
        RequestDispatcher dispatcher = req.getRequestDispatcher(SIGNUP_PAGE);
        dispatcher.forward(req, resp);
    }
}