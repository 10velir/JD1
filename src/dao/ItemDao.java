package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Item;

/**
 * Class ItemDao
 *
 * Created by yslabko on 07/02/2017.
 */
public interface ItemDao extends DAO<Item>{
    List<Item> getByOrderId(long orderId) throws SQLException;
}
