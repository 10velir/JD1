package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Item;

/**
 * Class CarDao
 *
 * Created by yslabko on 07/02/2017.
 */
public interface CarDao extends DAO<Item>{
    List<Item> getByOrderId(long orderId) throws SQLException;
}
