package web.command.impl;

import entities.User;
import services.ProductService;
import services.UserService;
import services.impl.ProductServiceImpl;
import services.impl.UserServiceImpl;
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
    UserService userService = UserServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        User user = new User();
        String contextPath = req.getContextPath();
        String page = "WEB-INF/view/signup.jsp";
        if (login==null || password==null) {
            resp.setHeader("errorMsg", "Invalid Login or Password");
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
            return;
        } else {
            user.setName(name);
            user.setPassword(password);
            user.setLogin(login);
            if(userService.getByLogin(login)==null) {

                User persistUser = userService.createUser(user);
                req.getSession().setAttribute("user", userService.getByLogin(persistUser.getLogin()));
                resp.sendRedirect(contextPath + "/frontController?command=products");
                return;
            }
            User persistUser = userService.createUser(user);
            req.getSession().setAttribute("user", userService.getByLogin(persistUser.getLogin()));
            resp.sendRedirect(contextPath + "/frontController?command=products");
            return;
            /*resp.setHeader("errorMsg", "This login is already exist");
            RequestDispatcher dispatcher = req.getRequestDispatcher(page);
            dispatcher.forward(req, resp);
            return;*/

        }



        /*String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+ "/frontController?command=createOrder");*/
        /*RequestDispatcher dispatcher = req.getRequestDispatcher(SIGNUP_PAGE);
        dispatcher.forward(req, resp);*/
    }

}