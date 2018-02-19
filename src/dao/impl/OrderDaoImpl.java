package dao.impl;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.OrderDao;
import entities.Item;
import entities.Order;

/**
 * Class OrderDaoImpl
 *
 * Created by yslabko on 08/09/2017.
 */
public class OrderDaoImpl extends AbstractDao implements OrderDao {
    private static volatile OrderDao INSTANCE = null;

    /*private long id;
    private long userId;
    private List<Item> items = new ArrayList<>();
    private double total;
    private boolean paid;*/
    private static final String saveQuery = "INSERT INTO `ORDER` (USER_ID, TOTAL, DATE, PAID) VALUES (?, ?, now(), ?)";
    private static final String updateQuery = "UPDATE `ORDER` SET TOTAL=? AND PAID=? WHERE ID=?";
    private static final String getQuery = "SELECT ID, USER_ID FROM `ORDER` WHERE ID=?";
    private static final String getAllByUserQuery = "SELECT ID, USER_ID FROM `ORDER` WHERE USER_ID = ? ORDER BY ID DESC";
    private static final String deleteQuery = "DELETE FROM `ORDER` WHERE ID=?";
    private static final String getAllOrder = "SELECT ID, USER_ID, TOTAL, PAID FROM `ORDER` WHERE PAID=?";

    private PreparedStatement psSave;
    private PreparedStatement psUpdate;
    private PreparedStatement psGet;
    private PreparedStatement psGetAllByUserId;
    private PreparedStatement psDelete;
    private PreparedStatement psGetAllOrder;

    @Override
    public Order save(Order order) throws SQLException {
        psSave = prepareStatement(saveQuery, Statement.RETURN_GENERATED_KEYS);
        psSave.setLong(1, order.getUserId());
        psSave.setDouble(2, order.getTotal());
        psSave.setBoolean(3,order.isPaid());
        psSave.executeUpdate();
        ResultSet rs = psSave.getGeneratedKeys();
        if (rs.next()) {
            order.setId(rs.getLong(1));
        }
        close(rs);
        return order;
    }


    @Override
    public Order get(Serializable id) throws SQLException {
        psGet = prepareStatement(getQuery);
        psGet.setLong(1, (long)id);
        psGet.executeQuery();
        ResultSet rs = psGet.getResultSet();
        if (rs.next()) {
            return populateEntity(rs);
        }
        close(rs);

        return null;
    }

    @Override
    public void update(Order order) throws SQLException {
        psUpdate = prepareStatement(updateQuery);
        psUpdate.setLong(1, order.getId());
        psUpdate.setDouble(3, order.getTotal());
        psUpdate.setBoolean(2, order.isPaid());
        psUpdate.executeUpdate();
    }


    @Override
    public void update(boolean paidStatus, Serializable id) throws SQLException {
        psUpdate = prepareStatement("UPDATE 'ORDER' SET PAID=? WHERE ID=?");
        psUpdate.setBoolean(1,paidStatus);
        psUpdate.setLong(2, (long) id);
        psUpdate.executeUpdate();
    }

    @Override
    public int delete(Serializable id) throws SQLException {
        psDelete = prepareStatement(deleteQuery);
        psDelete.setLong(1, (long)id);
        return psDelete.executeUpdate();
    }

    @Override
    public List<Order> getByUserId(long userId) throws SQLException {
        psGetAllByUserId = prepareStatement(getAllByUserQuery);
        psGetAllByUserId.setLong(1, userId);
        psGetAllByUserId.execute();
        ResultSet rs = psGetAllByUserId.getResultSet();
        List<Order> list = new ArrayList<>();
        while (rs.next()) {
            list.add(populateEntity(rs));
        }
        close(rs);

        return list;
    }
    @Override
    public List<Order> getAllOrder() throws SQLException {
        psGetAllOrder = prepareStatement(getAllOrder);
        psGetAllOrder.setBoolean(1,false);
        psGetAllOrder.execute();
        ResultSet resultSet = psGetAllOrder.getResultSet();
        //ResultSet resultSet = psGetAllOrder.getResultSet();
        List<Order> list = new ArrayList<>();
        while (resultSet.next()) {
            list.add(
                    new Order(
                    resultSet.getLong(1),
                    resultSet.getLong(2),
                            CarDaoImpl.getInstance().getByOrderId(resultSet.getLong(1)),
                            resultSet.getDouble(3),
                            resultSet.getBoolean(4)
                            )
            );
            //list.add(populateEntity(resultSet));
        }
        close(resultSet);

        return list;
    }

    private Order populateEntity(ResultSet rs) throws SQLException {
        Order entity = new Order();
            entity.setId(rs.getLong(1));
            entity.setUserId(rs.getLong(2));
        return entity;
    }

    public static OrderDao getInstance() {
        OrderDao itemDao = INSTANCE;
        if (itemDao == null) {
            synchronized (CarDaoImpl.class) {
                itemDao = INSTANCE;
                if (itemDao == null) {
                    INSTANCE = itemDao = new OrderDaoImpl();
                }
            }
        }

        return itemDao;
    }
}
