package web.command.impl;

import entities.Order;
import services.OrderService;
import services.impl.OrderServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminOrdersController implements Controller {

    OrderService orderService = OrderServiceImpl.getInstance();
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<Order> allOrder = orderService.getAllOrder();
        req.setAttribute("allOrders", allOrder);
        String contextPath = req.getContextPath();
        //resp.sendRedirect(contextPath+ "/frontController?command=adminOrders");

        //req.setAttribute("orders", orders);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);

    }
}
