package services;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import entities.Order;

/**
 * Class OrderService
 *
 * Created by yslabko on 08/09/2017.
 */
public interface OrderService {

    Order createOrder(long userId, long productId, int quantity);
    Order get(Serializable id);
    void update(Order order);
    void update(boolean paidStatus, Serializable id);
    int delete(Serializable id);
    List<Order> getAllOrder();

    List<Order> getByUserId(long userId);
}
