package dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import entities.Order;

/**
 * Class OrderDao
 *
 * Created by yslabko on 08/08/2017.
 */
public interface OrderDao extends DAO <Order> {
    void update(boolean paidStatus, Serializable id) throws SQLException;
    List<Order> getByUserId(long userId) throws SQLException;
    List<Order> getAllOrder() throws SQLException;
}