package web.command.impl;
import dao.OrderDao;
import dao.impl.OrderDaoImpl;
import services.OrderService;
import services.impl.OrderServiceImpl;
import web.command.Controller;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class DeleteOrderController implements Controller {
    private OrderService orderService = OrderServiceImpl.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long orderId = Long.parseLong(req.getParameter("orderId"));
        orderService.delete(orderId);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+ "/frontController?command=orders");
        /*RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);*/
    }

}