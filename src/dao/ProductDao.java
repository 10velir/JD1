package dao;

import java.sql.SQLException;
import java.util.List;

import entities.Car;

/**
 * Class ProductDao
 *
 * Created by yslabko on 08/08/2017.
 */
public interface ProductDao extends DAO<Car> {
    Car getByModelAndSupplier(String model, String supplier) throws SQLException;
    List<Car> getAll() throws SQLException;
}
