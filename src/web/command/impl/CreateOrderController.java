package web.command.impl;

import entities.Order;
import entities.User;
import services.OrderService;
import services.impl.OrderServiceImpl;
import web.command.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by yslabko on 08/17/2017.
 */
public class    CreateOrderController implements Controller {
    private OrderService orderService = OrderServiceImpl.getInstance();

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        long productId;

        Order order;

        if ((req.getParameter("productId") != null)) {
            productId = Long.parseLong(req.getParameter("productId"));
            order = orderService.createOrder(user.getId(), productId, 0);
        } /*else{

            orderService.get(Long.parseLong(req.getParameter("orderId")));
            Optional<Order> first = orderService.getByUserId(user.getId())
                    .stream()
                    .filter(order1 -> order1.getId() == Long.parseLong(req.getParameter("orderId")))
                    .findFirst();

            order=first.get();
            req.getParameter("order");//orderService.get(Long.parseLong(req.getParameter("orderId")));
        }*/

        List<Order> orders = orderService.getByUserId(user.getId());

        req.setAttribute("orders", orders);

        if (!(req.getParameter("paid") == null || req.getParameter("paid").isEmpty())) {
            req.getSession().setAttribute("user", user);
            orderService.update(true, Long.parseLong(req.getParameter("orderId")));
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/frontController?command=createOrder");
            return;
        }
        //req.setAttribute("order", order);
        RequestDispatcher dispatcher = req.getRequestDispatcher(MAIN_PAGE);
        dispatcher.forward(req, resp);
    }

}