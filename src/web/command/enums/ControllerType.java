package web.command.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import web.command.Controller;
import web.command.impl.*;

/**
 * Created by yslabko on 08/13/2017.
 */
@Getter
@AllArgsConstructor
public enum ControllerType {
    LOGIN("login.jsp", "Login", "login.title", new LoginController()),
    LOGOUT("login.jsp", "Logout", "logout.title", new LogoutController()),
    ORDERS("orders/main.jsp", "Orders", "orders.title", new OrderController()),
    ORDERS_FOR_ADMIN("orders/main.jsp", "Orders", "orders.title", new OrderController()),
    ADD_PRODUCTS_AJAX("", "addProduct", "", new AddToBasketController()),
    SIGNUP("signup.jsp", "signup", "login.submit", new SignupController()),
    DELETE_ORDER("", "deleteOrder", "createOrder.title", new DeleteOrderController()),
    PRODUCTS("products/main.jsp", "Products", "products.title", new ProductController()),
    CREATE_ORDER("orders/createOrder.jsp", "createOrder", "createOrder.title", new CreateOrderController()),
    ADMIN_ORDERS("orders/adminOrders.jsp", "adminOrders", "adminOrders.title", new AdminOrdersController());
    private String pagePath;
    private String pageName;
    private String i18nKey;
    private Controller controller;

    public static ControllerType getByPageName(String page) {
        for (ControllerType type : ControllerType.values()) {
            if (type.pageName.equalsIgnoreCase(page)) {
                return type;
            }
        }
// Если ничего не найдено, то на главную страницу с продуктами
        return PRODUCTS;
    }
}
